package com.hasu.zzol.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hasu.zzol.member.Member;
import com.hasu.zzol.member.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final MemberRepository memberRepository;

    @Value("${kakao.rest-api-key}")
    private String restApiKey;
    @Value("${kakao.redirect-uri}")
    private String redirectUri;
    @Value("${kakao.client-secret}")
    private String clientSecret;

    @Transactional
    public KakaoTokenDto getKakaoAccessToken(String code) {
        System.out.println(code);
        System.out.println(restApiKey);
        System.out.println(redirectUri);
        System.out.println(clientSecret);

        // 인가 코드로 카카오 액세스 토큰 요청
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code"); //카카오 공식문서 기준 authorization_code 로 고정
        params.add("client_id", restApiKey); // 카카오 Dev 앱 REST API 키
        params.add("redirect_uri",redirectUri); // 카카오 Dev redirect uri
        params.add("code", code); // 프론트에서 인가 코드 요청시 받은 인가 코드값
        params.add("client_secret", clientSecret); // 카카오 Dev 카카오 로그인 Client Secret

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> accessTokenResponse = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        // JSON Parsing (-> KakaoTokenDto)
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        KakaoTokenDto kakaoTokenDto = null;
        try {
            kakaoTokenDto = objectMapper.readValue(accessTokenResponse.getBody(), KakaoTokenDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return kakaoTokenDto;
    }




    @Transactional
    public ResponseEntity<SignInResponseDto> kakaoLogin(String kakaoAccessToken) {
        // 카카오 액세스 토큰으로 카카오 계정 정보 조회
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + kakaoAccessToken);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoAccountInfoRequest = new HttpEntity<>(headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> kakaoAccountInfoResponse = rt.exchange(
                "https://kapi.kakao.com/v2/user/me", HttpMethod.GET, kakaoAccountInfoRequest, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        KakaoAccountResponseDto kakaoAccountInfo = null;
        try {
            kakaoAccountInfo = objectMapper.readValue(kakaoAccountInfoResponse.getBody(), KakaoAccountResponseDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 동일한 카카오 id를 가진 계정이 있는지 조회
        SignInResponseDto signInResponse = new SignInResponseDto();
        signInResponse.setKakaoId(kakaoAccountInfo.getId());
        signInResponse.setKakaoAccount(kakaoAccountInfo.getKakao_account());
        Optional<Member> om = memberRepository.findByKakaoId(kakaoAccountInfo.getId());
        signInResponse.setRegistered(om.isPresent());
        return ResponseEntity.ok(signInResponse);

    }
}
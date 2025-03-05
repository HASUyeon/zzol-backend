package com.hasu.zzol.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hasu.zzol.member.Member;
import lombok.Data;

@Data
public class SignInResponseDto {
    @JsonProperty("isRegistered")
    private boolean isRegistered; // 회원가입을 한 회원인지 여부
    private Long kakaoId;
    private KakaoAccountDto kakaoAccount;
    private Member member; // 회원가입을 한 회원일 때 채워서 줌
    private AuthTokens token;
}
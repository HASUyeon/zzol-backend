package com.hasu.zzol.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Tag(name="Auth", description = "로그인, 회원가입 등 비로그인 회원이 이용")
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/sign-in/kakao")
    @Operation(summary = "카카오 로그인", description = "프론트에서 전달한 인가 코드로 회원 여부 조회, 액세스 토큰 발급")
    @Parameter(name = "code", description = "카카오 인가코드")
    public ResponseEntity<SignInResponseDto> kakaoLogin(HttpServletRequest request) {
        // 프론트에서 전달한 인가 코드로 카카오 accessToken 발급
        String code = request.getParameter("code");
        KakaoTokenDto kakaoToken= authService.getKakaoAccessToken(code);
        return authService.kakaoLogin(kakaoToken.getAccess_token());
    }

    @PostMapping("/sign-up/kakao")
    @Operation(summary = "카카오 회원가입", description = "카카오 계정과 회원가입 페이지에서 작성한 정보로 회원 등록")
    public ResponseEntity<SignUpResponseDto> kakaoSignUp(@RequestBody SignUpRequestDto requestDto) {
        return ResponseEntity.ok(authService.kakaoSignUp(requestDto));

    }
}
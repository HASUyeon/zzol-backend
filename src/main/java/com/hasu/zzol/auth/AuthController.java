package com.hasu.zzol.auth;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/sign-in/kakao")
    @ResponseBody
    public ResponseEntity<SignInResponseDto> kakaoLogin(HttpServletRequest request) {
        // 프론트에서 전달한 인가 코드로 카카오 accessToken 발급
        String code = request.getParameter("code");
        KakaoTokenDto kakaoToken= authService.getKakaoAccessToken(code);
        return authService.kakaoLogin(kakaoToken.getAccess_token());
    }

    @PostMapping("/sign-up/kakao")
    @ResponseBody
    public ResponseEntity<SignUpResponseDto> kakaoSignUp(@RequestBody SignUpRequestDto requestDto) {
        return ResponseEntity.ok(authService.kakaoSignUp(requestDto));

    }
}
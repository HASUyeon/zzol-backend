package com.hasu.zzol.auth;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    @GetMapping("/sign-in/oauth2/kakao")
    public void kakaoLogin(HttpServletRequest request) {
        // 프론트에서 전달한 인가 코드로 카카오 accessToken 발급
        String code = request.getParameter("code");
        String kakaoAccessToken = authService.getKakaoAccessToken(code).getAccess_token();
    }
}

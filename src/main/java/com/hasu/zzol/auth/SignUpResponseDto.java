package com.hasu.zzol.auth;

import com.hasu.zzol.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignUpResponseDto {
    private String message;
    private Long kakaoId;
    private KakaoAccountDto kakaoAccount;
    private Member member; // 회원가입을 한 회원일 때 채워서 줌
    private AuthTokens token;
}

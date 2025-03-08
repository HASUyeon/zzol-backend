package com.hasu.zzol.auth;

import lombok.Data;

@Data
public class KakaoAccountResponseDto {
    Long id; // 카카오 회원번호
    KakaoAccountDto kakao_account; // 카카오 계정 정보
}

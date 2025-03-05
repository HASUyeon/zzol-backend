package com.hasu.zzol.auth;

import lombok.Data;

@Data
public class KakaoTokenDto {
    private String token_type; // bearer 로 고정
    private String access_token;
    private String refresh_token;
    private String id_token; // OpenId Connect 확장 기능에 이용
    private int expires_in; // access_token, id_token 만료 시간(초)
    private int refresh_token_expires_in; // refresh_token 만료 시간(초)
    private String scope; // 사용자의 정보 조회 권한 범위
}

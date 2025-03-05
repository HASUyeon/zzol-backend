package com.hasu.zzol.auth;

import lombok.Data;

@Data
public class KakaoAccountDto {
    String email;
    Boolean has_email;
    Boolean is_email_valid;
    Boolean is_email_verified;
}

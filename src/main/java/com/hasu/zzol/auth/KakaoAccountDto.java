package com.hasu.zzol.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class KakaoAccountDto {
    @Schema(description = "카카오계정 대표 이메일")
    String email;

    @Schema(description = "이메일 존재 여부(deprecated)")
    Boolean has_email;

    @Schema(description = "이메일 유효 여부")
    Boolean is_email_valid;

    @Schema(description = "이메일 인증 여부")
    Boolean is_email_verified;
}

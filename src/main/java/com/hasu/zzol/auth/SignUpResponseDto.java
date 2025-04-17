package com.hasu.zzol.auth;

import com.hasu.zzol.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignUpResponseDto {
    @Schema(description = "회원 정보")
    private Member member;

    @Schema(description = "토큰")
    private AuthTokens token;
}

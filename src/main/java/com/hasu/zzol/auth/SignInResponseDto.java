package com.hasu.zzol.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hasu.zzol.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInResponseDto {
    @JsonProperty("isRegistered")
    @Schema(description = "회원가입을 한 회원인지 여부")
    private boolean isRegistered; // 회원가입을 한 회원인지 여부

    @NotBlank
    @Schema(description = "카카오 회원번호")
    private Long kakaoId;

    @Schema(description = "카카오 계정 정보")
    private KakaoAccountDto kakaoAccount;

    @Schema(description = "회원 정보")
    private Member member; // 회원가입을 한 회원일 때 채워서 줌
}
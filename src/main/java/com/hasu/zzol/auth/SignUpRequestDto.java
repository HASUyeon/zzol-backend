package com.hasu.zzol.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignUpRequestDto {
    @NotBlank
    @Schema(description = "카카오 회원번호")
    private Long kakaoId;

    @NotBlank
    @Size(min = 1, max = 20)
    @Schema(description = "닉네임")
    private String nickname;

    @NotBlank
    @Schema(description = "이메일(카카오 이메일)")
    private String email;

    @NotBlank
    @Schema(description = "생년월일")
    private LocalDate birthDate;
//    private String profileImgUrl;
}

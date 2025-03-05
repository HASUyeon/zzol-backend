package com.hasu.zzol.auth;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignUpRequestDto {
    private Long kakaoId;
    private String nickname;
    private String email;
    private LocalDate birthDate;
//    private String profileImgUrl;
}

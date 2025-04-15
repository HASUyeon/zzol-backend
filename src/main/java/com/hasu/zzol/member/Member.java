package com.hasu.zzol.member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	@Schema(description = "회원번호")
	private Integer memberNo;

	@NotBlank
	@Schema(description = "카카오 회원번호")
	private Long kakaoId;

	@Schema(description = "이름")
	private String name;
	
	@Column(length = 20, unique = true)
	@NotBlank
	@Size(min = 1, max = 20)
	@Schema(description = "닉네임")
	private String nickname;
	
	@Column(unique = true)
	@NotBlank
	@Schema(description = "이메일")
	private String email;

	@NotBlank
	@Schema(description = "생년월일")
	private LocalDate birthDate;

	@Schema(description = "프로필 이미지 url")
	private String profileImgUrl;

	@NotBlank
	@Schema(description = "회원가입 일시")
	private LocalDateTime createDt;

	@NotBlank
	@Schema(description = "회원 상태")
	private String memberState;
	
}

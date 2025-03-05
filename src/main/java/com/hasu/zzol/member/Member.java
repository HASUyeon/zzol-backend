package com.hasu.zzol.member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Integer memberNo;
	
	private Long kakaoId;
	
	private String name;
	
	@Column(length = 20, unique = true)
	private String nickname;
	
	@Column(unique = true)
	private String email;
	
	private LocalDate birthDate;
	
	private String profileImgUrl;
	
	private LocalDateTime createDt;
	
	private String memberState;
	
}

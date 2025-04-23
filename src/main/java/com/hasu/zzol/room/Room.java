package com.hasu.zzol.room;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    @Schema(description = "방 번호")
    private Integer roomNo;

    @Schema(description = "방 제목")
    private String roomName;

    @NotBlank
    @Schema(description = "게임 모드")
    private String gameMode;

    @NotBlank
    @Schema(description = "내기 모드")
    private String betMode;

    @NotBlank
    @Schema(description = "현재 인원")
    private Integer currentMemberCnt;

    @NotBlank
    @Schema(description = "최대 인원")
    private Integer maxMemberCnt;

    @NotBlank
    @Schema(description = "방 등록 일시")
    private LocalDate createDt;

    @NotBlank
    @Schema(description = "방 상태")
    private RoomState roomState;

    @NotBlank
    @Schema(description = "방 등록 회원 번호")
    private Integer createMemberNo;

    @Schema(description = "게임 시작 일시")
    private LocalDateTime startDt;

    @Schema(description = "게임 종료 일시")
    private LocalDateTime endDt;

    @Schema(description = "대진표")
    private Integer bracketNo;

}

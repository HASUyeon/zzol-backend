package com.hasu.zzol.room;

import lombok.Getter;

@Getter
public enum GameMode {
    RPS("가위바위보"),
    RPS_MINUS_ONE("가위바위보 하나 빼기");

    private final String name;
    GameMode(String name) {
        this.name = name;
    }
}

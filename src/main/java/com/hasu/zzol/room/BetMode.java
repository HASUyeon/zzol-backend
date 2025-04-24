package com.hasu.zzol.room;

import lombok.Getter;

@Getter
public enum BetMode {
    TOGETHER("다 함께"),
    ONE_BY_ONE("따로따로");

    private final String name;

    BetMode(String name) {
        this.name = name;
    }
}

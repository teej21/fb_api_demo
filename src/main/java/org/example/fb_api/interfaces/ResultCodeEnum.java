package org.example.fb_api.interfaces;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(0),
    FAILURE(-1);

    private final int value;

    ResultCodeEnum(int value) {
        this.value = value;
    }

}
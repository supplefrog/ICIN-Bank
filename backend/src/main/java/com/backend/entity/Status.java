package com.backend.entity;

import lombok.Getter;

@Getter
public enum Status {

    OPEN("OPEN"),
    APPROVED("APPROVED"),
    CLOSED("CLOSED"),
    DENIED("DENIED");


    private final String description;

    Status(String description) {
        this.description = description;
    }

}

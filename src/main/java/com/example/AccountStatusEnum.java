package com.example;

import lombok.Getter;

@Getter
public enum AccountStatusEnum {
    INACTIVE(0, "Inactive"),
    ACTIVE(1, "Active"),
    LOCKED(2, "Locked"),
    DELETED(3, "Deleted");

    private final int code;
    private final String desc;

    AccountStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}

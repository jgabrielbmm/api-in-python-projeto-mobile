package com.icev.mobile.tea.domain;

public enum GenderType {
    MALE,
    FEMALE,
    OTHER;


    static GenderType convert(String gender) {
        try {
            return GenderType.valueOf(gender.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException exception) {
            throw new RuntimeException("Invalid value of gender");
        }
    }

}

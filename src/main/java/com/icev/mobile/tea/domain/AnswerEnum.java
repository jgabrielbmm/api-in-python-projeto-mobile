package com.icev.mobile.tea.domain;


public enum AnswerEnum {
    YES,
    NO,
    UNKNOWN;

    static AnswerEnum convert(String answer) {
        try {
            return AnswerEnum.valueOf(answer.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException exception) {
            throw new RuntimeException("Invalid value of gender");
        }
    }

}

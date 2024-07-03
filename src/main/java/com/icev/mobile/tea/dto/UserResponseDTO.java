package com.icev.mobile.tea.dto;

import com.icev.mobile.tea.domain.AnswerEnum;
import com.icev.mobile.tea.domain.GenderType;

import java.util.Date;

public record UserResponseDTO(String name, String email, GenderType gender, String city, String state, AnswerEnum isASD, AnswerEnum knowSomeoneWithASD) {
}

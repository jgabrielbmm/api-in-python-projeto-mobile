package com.icev.mobile.tea.dto;

import com.icev.mobile.tea.domain.GenderType;

import java.util.Date;

public record UserUpdateRequestDTO(String name, String email, Date dateOfBirth, GenderType gender, Boolean isASD, Boolean knowSomeoneWithASD) {
}

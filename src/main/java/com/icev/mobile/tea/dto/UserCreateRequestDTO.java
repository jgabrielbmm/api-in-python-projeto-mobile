package com.icev.mobile.tea.dto;

import com.icev.mobile.tea.domain.GenderType;

import java.util.Date;

public record UserCreateRequestDTO(String name, String email, Date dateOfBirth, GenderType gender, String city, String state, Boolean isASD, Boolean knowSomeoneWithASD) {
}

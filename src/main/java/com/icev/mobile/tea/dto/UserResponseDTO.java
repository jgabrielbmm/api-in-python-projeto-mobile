package com.icev.mobile.tea.dto;

import java.util.Date;

public record UserResponseDTO(String name, String email, Date dateOfBirth, Boolean isASD, Boolean knowSomeoneWithASD) {
}

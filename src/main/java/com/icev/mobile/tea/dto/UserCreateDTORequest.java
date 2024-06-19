package com.icev.mobile.tea.dto;

import java.util.Date;

public record UserCreateDTORequest(String name, String email, Date dateOfBirth, Boolean isASD, Boolean knowSomeoneWithASD) {
}

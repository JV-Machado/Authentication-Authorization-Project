package com.projects.gamelibrary.dto;

import com.projects.gamelibrary.entities.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

	
}

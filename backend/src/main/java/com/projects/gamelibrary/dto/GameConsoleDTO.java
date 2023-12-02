package com.projects.gamelibrary.dto;

import com.projects.gamelibrary.entities.GameConsole;

public class GameConsoleDTO {

	private Long id;
	private String name;
	
	public GameConsoleDTO() {
	}
	
	public GameConsoleDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public GameConsoleDTO(GameConsole entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

package com.projects.gamelibrary.dto;

import com.projects.gamelibrary.entities.Game;

public class GameDTO {
	
	private Long id;
	private String name;
	private String description;
	private String releaseYear;
	private String imgUrl;
	
	public GameDTO() {
		
	}
	
	public GameDTO(Long id, String name, String description, String releaseYear, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.releaseYear = releaseYear;
		this.imgUrl = imgUrl;
	}

	public GameDTO(Game entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.releaseYear = entity.getReleaseYear();
		this.imgUrl = entity.getImgUrl();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}

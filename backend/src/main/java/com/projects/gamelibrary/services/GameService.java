package com.projects.gamelibrary.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.gamelibrary.dto.GameDTO;
import com.projects.gamelibrary.entities.Game;
import com.projects.gamelibrary.repositories.GameRepository;
import com.projects.gamelibrary.services.exceptions.DatabaseException;
import com.projects.gamelibrary.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {

	@Autowired
	public GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		List<Game> list = repository.findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Optional<Game> obj = repository.findById(id);
		Game entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id no found " + id));
		return new GameDTO(entity);
	}

	@Transactional
	public GameDTO insert(GameDTO dto) {
		Game entity = new Game();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setReleaseYear(dto.getReleaseYear());
		entity.setImgUrl(dto.getImgUrl());
		entity = repository.save(entity);
		return new GameDTO(entity);
	}

	@Transactional
	public GameDTO update(Long id, GameDTO dto) {
		try {
			Game entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setReleaseYear(dto.getReleaseYear());
			entity.setImgUrl(dto.getImgUrl());
			entity = repository.save(entity);
			return new GameDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id no found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id no found " + id);
		}
	}

	
}

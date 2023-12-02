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

import com.projects.gamelibrary.dto.GameConsoleDTO;
import com.projects.gamelibrary.entities.GameConsole;
import com.projects.gamelibrary.repositories.GameConsoleRepository;
import com.projects.gamelibrary.services.exceptions.DatabaseException;
import com.projects.gamelibrary.services.exceptions.ResourceNotFoundException;

@Service
public class GameConsoleService {

	@Autowired
	private GameConsoleRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameConsoleDTO> findAll(){
		List<GameConsole> list = repository.findAll();
		return list.stream().map(x -> new GameConsoleDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public GameConsoleDTO findById(Long id) {
		Optional<GameConsole> obj = repository.findById(id);
		GameConsole entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new GameConsoleDTO(entity);
	}

	@Transactional
	public GameConsoleDTO insert(GameConsoleDTO dto) {
		GameConsole entity = new GameConsole();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new GameConsoleDTO(entity);
	}

	@Transactional
	public GameConsoleDTO update(Long id, GameConsoleDTO dto) {
		try {
			GameConsole entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new GameConsoleDTO(entity);
		}
		catch (EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	
}

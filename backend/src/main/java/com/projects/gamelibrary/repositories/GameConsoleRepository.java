package com.projects.gamelibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.gamelibrary.entities.GameConsole;

@Repository
public interface GameConsoleRepository extends JpaRepository<GameConsole, Long>{

}

package com.projects.gamelibrary.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.projects.gamelibrary.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

	UserDetails findByLogin(String login);
}

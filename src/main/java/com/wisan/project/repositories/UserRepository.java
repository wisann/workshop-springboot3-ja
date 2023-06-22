package com.wisan.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisan.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}

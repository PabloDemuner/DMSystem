package com.dmsystem.vendasdeprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmsystem.vendasdeprodutos.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}

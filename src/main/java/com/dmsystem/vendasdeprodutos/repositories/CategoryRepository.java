package com.dmsystem.vendasdeprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmsystem.vendasdeprodutos.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}

package com.dmsystem.vendasdeprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmsystem.vendasdeprodutos.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

package com.dmsystem.vendasdeprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmsystem.vendasdeprodutos.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}

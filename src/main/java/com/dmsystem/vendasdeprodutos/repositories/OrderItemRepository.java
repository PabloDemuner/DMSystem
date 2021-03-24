package com.dmsystem.vendasdeprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmsystem.vendasdeprodutos.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}

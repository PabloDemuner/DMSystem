package com.dmsystem.vendasdeprodutos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmsystem.vendasdeprodutos.entities.Order;
import com.dmsystem.vendasdeprodutos.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order finById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}

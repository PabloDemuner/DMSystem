package com.dmsystem.vendasdeprodutos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmsystem.vendasdeprodutos.entities.Category;
import com.dmsystem.vendasdeprodutos.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category finById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}

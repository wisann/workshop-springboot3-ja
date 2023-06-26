package com.wisan.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisan.project.entities.Category;
import com.wisan.project.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id).get();
	}

	public Category insert(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	public Category update(Long id, Category obj) {
		Category entity = categoryRepository.getReferenceById(id);
		updateData(entity, obj);
		return categoryRepository.saveAndFlush(entity);
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());

	}

	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

}

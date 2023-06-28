package com.wisan.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.wisan.project.entities.Category;
import com.wisan.project.repositories.CategoryRepository;
import com.wisan.project.service.exceptions.ResourceNotFundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFundException(id));
	}

	public Category insert(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	public Category update(Long id, Category obj) {
		try {
			Category entity = categoryRepository.getReferenceById(id);
			updateData(entity, obj);
			return categoryRepository.saveAndFlush(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFundException(id);
		}
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());

	}
	

	public void delete(Long id) {
		try {
			if (categoryRepository.existsById(id)) {
				categoryRepository.deleteById(id);
			} else {
				throw new ResourceNotFundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Data integrity violation occurred.");
		}
	}

}

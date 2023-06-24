package com.wisan.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisan.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

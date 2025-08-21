package com.eshop.shopease.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.shopease.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByCategoryName(String categoryName);
}

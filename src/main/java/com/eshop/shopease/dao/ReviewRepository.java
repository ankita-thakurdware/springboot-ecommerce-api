package com.eshop.shopease.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.shopease.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	Optional<Review> findByPid(Long pid);
	Optional<Review> findByUid(Long uid);
	

}

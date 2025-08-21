package com.eshop.shopease.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.shopease.entity.WishListItem;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem, Long>{
	
	List<WishListItem> findByWishlistId(Long wishlistId);
	List<WishListItem> findBypid(Long pid);
	}

package com.eshop.shopease.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.shopease.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
	
	List<WishList> findByUid(Long uid);

}

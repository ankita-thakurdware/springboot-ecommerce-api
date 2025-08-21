package com.eshop.shopease.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity
@Table(name="wishlists")
public class WishList {
      
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long wishlistId;
	
	@Builder.Default
	@OneToMany(mappedBy="wishlist",cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference
	@ToString.Exclude
	private List<WishListItem> wishlistItems=new ArrayList<WishListItem>();
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name="uid",nullable=false)
	@ToString.Exclude
	private User user;
}

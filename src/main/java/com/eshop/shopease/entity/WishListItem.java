package com.eshop.shopease.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity
@Table(name="wishlistitem",uniqueConstraints= {
		@UniqueConstraint(columnNames= {"uid","pid"})
})
public class WishListItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long wishlistItemId;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="wishlistId",nullable=false)
	private WishList wishlist;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Product product;
}

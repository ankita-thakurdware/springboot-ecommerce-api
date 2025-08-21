package com.eshop.shopease.entity;

import java.math.BigDecimal;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long cartId;
	
	@Builder.Default
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL,orphanRemoval = true)
	@ToString.Exclude
	@JsonManagedReference
	private List<CartItem> cartItems=new ArrayList<CartItem>();
	
	@ManyToOne(optional=false)
	@JsonBackReference
	@ToString.Exclude
	@JoinColumn(name="uid")
	private User user;
	
	@Transient
	public BigDecimal getTotalPrice() {
	    return cartItems.stream()
	        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
	        .reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	
}

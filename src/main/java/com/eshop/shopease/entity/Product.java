package com.eshop.shopease.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long pid;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String description;
	
	@Column(nullable=false)
	private BigDecimal price;
	
	@Column
	private int stockQuantity;
	
	
	
	@ToString.Exclude
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="categoryId")
	private Category category;
	
	@ToString.Exclude
	@JsonManagedReference
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<ProductImage> images;
	
	@ToString.Exclude
	@JsonManagedReference
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Review> reviews;
	
	
	
}

package com.eshop.shopease.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="orderitems")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long orderItemId;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false,precision=10,scale=2)
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	@JsonBackReference
	@ToString.Exclude
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="pid")
    @JsonBackReference
    @ToString.Exclude
    private Product product;
}

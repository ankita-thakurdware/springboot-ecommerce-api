package com.eshop.shopease.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.eshop.shopease.dao.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name="uid")
	@JsonBackReference
	@ToString.Exclude
	private User user;
	
	@CreationTimestamp
	private LocalDateTime orderDate;
	
	@Column(nullable=false,precision=10,scale=2)
	private BigDecimal totalPrice;
	
	@Column(nullable=false)
	private String shippingAddress;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private OrderStatus orderStatus;
	
	@OneToOne(mappedBy="order",cascade=CascadeType.ALL)
	@JsonManagedReference
	@ToString.Exclude
	private Payment payment;
}

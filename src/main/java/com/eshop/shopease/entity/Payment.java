package com.eshop.shopease.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.eshop.shopease.dao.enums.PaymentMethod;
import com.eshop.shopease.dao.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name="payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Payment {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long paymentId;
	
	@Column(nullable=false,precision=10,scale=2)
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=50)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=20)
	private PaymentStatus status;
	
	@Column(nullable=false,updatable=false)
	@CreationTimestamp
	private LocalDateTime paymentDate;
	
	@ManyToOne
	@JoinColumn(name="uid",nullable=false)
	@JsonBackReference
	@ToString.Exclude
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="orderId",nullable=false)
	@JsonBackReference
	@ToString.Exclude
	private Order order;
}

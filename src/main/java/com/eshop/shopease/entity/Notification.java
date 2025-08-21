package com.eshop.shopease.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@ToString(exclude="user")
@Entity
@Table(name="notifications")
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long nId;
	
	@Column(nullable=false,length=255)
	private String message;
	
	@Builder.Default
	@Column(nullable=false)
	private boolean isRead=false;
	
	@CreationTimestamp
	@Column(nullable=false,updatable=false)
	private LocalDateTime createdAt;
	
	@ManyToOne
	private User user;
}

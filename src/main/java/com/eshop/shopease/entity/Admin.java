package com.eshop.shopease.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.eshop.shopease.entity.enums.AdminRoles;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long adminId;
	
	@Column(nullable=false,unique=true,length=100)
	@EqualsAndHashCode.Include
	private String adminCode;
	
	@Column(nullable=false,length=100)
	private String department;
	
	@CreationTimestamp
	private LocalDateTime joinedDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	@Builder.Default
	@Column(nullable=false)
	private boolean active=true;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=20)
	private AdminRoles aRole;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name="uid",nullable=false,unique=true)
	private User user;
}

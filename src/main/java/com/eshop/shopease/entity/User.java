package com.eshop.shopease.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long uid;
	
	@Column(nullable=false,unique=true,length=100)
	@EqualsAndHashCode.Include
	private String username;
	
	@Column(nullable=false,unique=true,length=150)
	@EqualsAndHashCode.Include
	private String email;
	
	@Setter
	@JsonIgnore
	@ToString.Exclude
	@Column(nullable=false)
	private String password;
	
	@Column(length=15)
	private String phoneNo;
	
	@Builder.Default
	@Column(nullable=false)
	private boolean active=true;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference
	@ToString.Exclude
	private List<ShoppingCart> carts;
	
	@CreationTimestamp
	@Column(nullable=false,updatable=false)
	private LocalDateTime createdAt;
	
	@Builder.Default
	@ManyToMany(fetch=FetchType.LAZY)
	@JsonBackReference
	@ToString.Exclude
	@JoinTable(name="roles",
	   joinColumns= @JoinColumn(name="uid"),
	   inverseJoinColumns= @JoinColumn(name="roleId"))
     private Set<Role> roles= new HashSet<>();
	
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	@JsonManagedReference
	private Admin admin;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonManagedReference
	@ToString.Exclude
	private WishList wishlist;
	
    @OneToMany(mappedBy="user")
    @JsonManagedReference
    @ToString.Exclude
    private Payment payment;
    
    @OneToMany(mappedBy="user")
    @JsonManagedReference
    @ToString.Exclude
    private Order order;
    
}

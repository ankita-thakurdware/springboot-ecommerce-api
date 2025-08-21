package com.eshop.shopease.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="review")
public class Review {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @EqualsAndHashCode.Include
   private int id;
   
   @ToString.Exclude
   @ManyToOne
   @JsonBackReference
   @JoinColumn(name="pid",nullable=false)
   private Product product;
   
   
   @ManyToOne
   private User user;
   
   
   @Column(nullable=false)
   private int rating;
   
   @Column(nullable=false,length=500)
   private String comment;
   
   @CreationTimestamp
   @Column(nullable=false)
   @EqualsAndHashCode.Include
   private LocalDate reviewDate;
   
}

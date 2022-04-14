/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evaluation.msa.product.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author limber.zenteno
 */
@Entity
@Getter
@Setter
@Table(name = "order_product")
public class OrderProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Basic
  @Column(name = "date_order")
  private Date dateOrder;
  
  @Basic 
  @Column(name = "description", length = 200)
  private String description;
  
  @ManyToMany(mappedBy = "orderProducts", fetch = FetchType.EAGER) 
  @JsonIgnoreProperties("orderProducts")
  Set<Product> products;
  
}

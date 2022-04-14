/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evaluation.msa.product.controller;

import com.evaluation.msa.product.entities.OrderProduct;
import com.evaluation.msa.product.repositories.OrderProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author limber.zenteno
 */
@Api( tags = {"OrderProduct" })
@RestController
public class OrderProductController {
  @Autowired
  private OrderProductRepository orderProductRepository;
  
  @ApiOperation(value = "Get list of orders", response = Iterable.class)
  @GetMapping("/orders_products")
  public Iterable<OrderProduct> getAllOrderProduct(){
    return orderProductRepository.findAll();
  }
  @ApiOperation(value = "Get order by description", response = Iterable.class)
  @GetMapping("/orders_products/{description}")
  public Iterable<OrderProduct> getOrderByDescription(@PathVariable String description){
    return orderProductRepository.findByDescription(description);
  }
  
  @ApiOperation(value = "Create orders", response = Iterable.class)
  @PostMapping("/orders_products")
  public OrderProduct createOrderProduct(OrderProduct orderProduct){
    return orderProductRepository.save(orderProduct);
  }
  
  @ApiOperation(value = "Edit orders", response = Iterable.class)
  @PutMapping("/orders_products")
  public OrderProduct editOrderProduct(OrderProduct orderProduct){
    return orderProductRepository.save(orderProduct);
  }
  
  @ApiOperation(value = "Get order by product", response = Iterable.class)
  @GetMapping("/orders_by_product/{id}")
  public Iterable<OrderProduct> getAllOrderByProduct(@PathVariable Integer id){
    return orderProductRepository.findAllByProducts_id(id);
  }
  
}

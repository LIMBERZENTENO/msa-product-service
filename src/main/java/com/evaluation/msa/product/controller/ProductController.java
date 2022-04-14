/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evaluation.msa.product.controller;

import com.evaluation.msa.product.entities.Product;
import com.evaluation.msa.product.repositories.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author limber.zenteno
 */
@Api(tags = {"Product"})
@RestController
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @ApiOperation(value = "Get list of products", response = Iterable.class)
  @GetMapping("/products")
  public Iterable<Product> getAllProduct() {
    return productRepository.findAll();
  }
  
  @ApiOperation(value = "Get products by name", response = Iterable.class)
  @GetMapping("/products/{name_product}")
  public Iterable<Product> getProductByName(@PathVariable String name_product) {
    return productRepository.findByNameProduct(name_product);
  }  

  @ApiOperation(value = "Create product", response = Iterable.class)
  @PostMapping("/products")
  public ResponseEntity<Product> createProduct(Product product) {
    try{
      Product save = productRepository.save(product);
      return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
    catch(Exception ex){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Product());
    }
    
  }
  
  @ApiOperation(value = "Edit product", response = Iterable.class)
  @PutMapping("/products")
  public Product editProduct(Product product) {
    Product save = productRepository.save(product);
    return save;
  }

  @ApiOperation(value = "Get product by order", response = Iterable.class)
  @GetMapping("/product_by_order/{id}")
  public Iterable<Product> getAllProductByOrder(@PathVariable Integer id) {
    return productRepository.findAllByOrderProducts_id(id);
  }

}

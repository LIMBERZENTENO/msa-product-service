/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evaluation.msa.product.repositories;

import com.evaluation.msa.product.entities.OrderProduct;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author limber.zenteno
 */
public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer>{
  
  List<OrderProduct> findAllByProducts_id(Integer id);
  
  List<OrderProduct> findByDescription(String description);
  
}

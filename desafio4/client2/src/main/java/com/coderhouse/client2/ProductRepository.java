package com.coderhouse.client2;

import org.springframework.data.repository.CrudRepository;

import com.coderhouse.client2.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
	
	
}
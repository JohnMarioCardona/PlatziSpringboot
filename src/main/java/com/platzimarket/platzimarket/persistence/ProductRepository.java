package com.platzimarket.platzimarket.persistence;

import java.util.List;

import com.platzimarket.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzimarket.platzimarket.persistence.entity.Producto;

public class ProductRepository {
	
	private ProductCrudRepository productCrudRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productCrudRepository.findAll();
	}
}

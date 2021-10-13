package com.platzimarket.platzimarket.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.platzimarket.platzimarket.persistence.entity.Producto;

public interface ProductCrudRepository extends CrudRepository<Producto, Integer>{

}

package com.platzimarket.platzimarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.platzimarket.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzimarket.platzimarket.persistence.entity.Producto;

public class ProductRepository {
	@Autowired
	private ProductCrudRepository productCrudRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productCrudRepository.findAll();
	}
	public List<Producto> getAllByIdCategoria(int IdCategoria){
		return (List<Producto>) productCrudRepository.findByIdCategoriaOrderByNombreAsc(IdCategoria);
	}
	public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
		return productCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado);
	}
}

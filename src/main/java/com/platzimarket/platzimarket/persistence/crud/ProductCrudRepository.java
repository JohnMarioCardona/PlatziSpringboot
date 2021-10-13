package com.platzimarket.platzimarket.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.platzimarket.platzimarket.persistence.entity.Producto;

public interface ProductCrudRepository extends CrudRepository<Producto, Integer>{
	
	public List<Producto> findByIdCategoriaOrderByNombreAsc(int IdCategoria);
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}

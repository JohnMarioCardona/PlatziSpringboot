package com.platzimarket.platzimarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.platzimarket.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzimarket.platzimarket.persistence.entity.Producto;

// tambien puede ser @Component pero esta es mas general.
@Repository //Utilizamos este decorador para decirle a spring que esta clase interactua con la base de datos
public class ProductRepository {

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
	public Optional<Producto> getProducto(int idProducto){
		return productCrudRepository.findById(idProducto);
	}
	public Producto  save(Producto producto) {
		return productCrudRepository.save(producto);
	}
	public void delete(int idProducto) {
		productCrudRepository.deleteById(idProducto);
	}
}

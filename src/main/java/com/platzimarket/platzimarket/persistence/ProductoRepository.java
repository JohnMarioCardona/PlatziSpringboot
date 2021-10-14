package com.platzimarket.platzimarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzimarket.platzimarket.domain.Product;
import com.platzimarket.platzimarket.domain.repository.ProductRepository;
import com.platzimarket.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzimarket.platzimarket.persistence.entity.Producto;
import com.platzimarket.platzimarket.persistence.mapper.ProductMapper;

// tambien puede ser @Component pero esta es mas general.
@Repository //Utilizamos este decorador para decirle a spring que esta clase interactua con la base de datos
public class ProductoRepository implements ProductRepository{

	@Autowired
	private ProductMapper mapper; 
	@Autowired
	private ProductCrudRepository productCrudRepository;
	
	@Override
	public List<Product> getAll(){
		List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
		// convertimos lista de productos a products
		return mapper.toProducts(productos);
	}
	
	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = (List<Producto>) productCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}
	
	@Override
	public Optional<Product> getProduct(int productId) {
		return productCrudRepository.findById(productId).map(prods -> mapper.toProduct(prods));
	}
	
	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}
	 
	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productCrudRepository.save(producto));
	}
	@Override
	public void delete(int productId) {
		productCrudRepository.deleteById(productId);
	}
}

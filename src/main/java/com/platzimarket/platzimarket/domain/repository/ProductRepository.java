package com.platzimarket.platzimarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.platzimarket.platzimarket.domain.Product;

//Establecemos reglas que va a tener el dominio para cuando cualquier
//repositorio quiera acceder a productos dentro de una base de datos.
// esto nos garantiza tener nuestra solucion no acoplada a una base de datos especifica
// siempre estaremos hablando en terminos de dominio -- product.
public interface ProductRepository {
	List<Product> getAll();
	Optional<List<Product>> getByCategory(int categoryId);
	Optional<List<Product>> getScarseProducts(int quantity);// get productos escasos
	Optional<Product> getProduct(int productId);
	Product save(Product product);
	void delete(int productId);
}

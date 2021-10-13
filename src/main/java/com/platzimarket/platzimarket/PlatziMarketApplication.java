package com.platzimarket.platzimarket;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.platzimarket.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzimarket.platzimarket.persistence.entity.Producto;

@SpringBootApplication
public class PlatziMarketApplication implements CommandLineRunner{

	@Autowired
	private ProductCrudRepository productCrudRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productCrudRepository.findByIdCategoriaOrderByNombreAsc(1);
	} 
	public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
		return productCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado);
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(getAll().get(1).getNombre());
		System.out.println(getEscasos(130,true).get().get(1).getNombre());
	}

}

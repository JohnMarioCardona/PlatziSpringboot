package com.platzimarket.platzimarket;

import java.util.List;

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
		return (List<Producto>) productCrudRepository.findAll();
	} 
	 
	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getAll().get(0).getNombre());
	}

}

package com.platzimarket.platzimarket.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzimarket.platzimarket.domain.Category;
import com.platzimarket.platzimarket.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	@Mappings({
		// fuente target donde quiero llevar
		// convertimos Categorias to domain.Category
		@Mapping(source = "idCategoria", target = "categoryId"),
		@Mapping(source = "descripcion", target = "category"),
		@Mapping(source = "estado", target = "active")
	})
	Category toCategory(Categoria categoria);
	
	// con esta notacion le indicamos que la conversion es lo 
	// opuesto que la superior, con esto nos ahorramos mappings.
	@InheritInverseConfiguration
	@Mapping(target = "productos", ignore = true) // en category no existe productos por ende se ignoran
	Categoria toCategoria(Category category);
}

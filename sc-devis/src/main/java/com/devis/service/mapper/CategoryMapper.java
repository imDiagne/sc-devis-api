package com.devis.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.devis.data.entity.Category;
import com.devis.service.dto.CategoryDto;

/**
 * Design Pattern Model Mapper  
 * @author ibrahimamadiodiodiagne
 *
 */
@Service
public class CategoryMapper extends AbstractMapper<Category, CategoryDto> {

	@Override
	public Category convertToEntity(CategoryDto categoryDto) {
		// TODO : Method checkCategoryMappingAlreadyExists();
		return map(categoryDto, Category.class);
	}

	@Override
	public CategoryDto convertToDto(Category categoryEntity) {
		// TODO : Method checkCategoryMappingAlreadyExists();
		return map (categoryEntity, CategoryDto.class);
	}

	@Override
	public List<Category> convertToListEntity(List<CategoryDto> dtos) {
		List<Category> categories = new ArrayList<>();
		if(dtos != null && !dtos.isEmpty()){
			dtos.stream().filter(dto -> dto != null).forEach(dto -> categories.add(convertToEntity(dto)));	
		}
		return categories;
	}

	@Override
	public List<CategoryDto> convertToListDto(List<Category> entities) {
	    List<CategoryDto> categoryDto = new ArrayList<>();
	    if((entities != null) && !entities.isEmpty()){
	    	entities.stream().filter(entitie -> entitie != null).forEach(entitie -> categoryDto.add(convertToDto(entitie)));
	    } 
		return categoryDto;
	}

	@Override
	public List<CategoryDto> convertCollectionToListDto(Collection<Category> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CategoryDto> convertCollectionToSetDto(Collection<Category> source) {
		Set<CategoryDto> destination = new HashSet<>();
		if (source != null) {
			source.stream().filter(Objects::nonNull).forEach(category -> destination.add(convertToDto(category)));
		}
		return destination;
	}
	
	
	/*
	private void checkWorkDtoMappingAlreadyExists() {
		TypeMap<Category, CategoryDto> typeMapCategoryDto = getTypeMap(Category.class, CategoryDto.class);
		if (typeMapCategoryDto == null) {
			addMappings(new CategoryDto());
		}
	}*/

	

}

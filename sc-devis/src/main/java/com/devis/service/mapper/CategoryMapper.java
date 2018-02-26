package com.devis.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
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
	public Category convertToEntity(CategoryDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto convertToDto(Category entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> convertToListEntity(List<CategoryDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> convertToListDto(List<Category> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> convertCollectionToListDto(Collection<Category> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CategoryDto> convertCollectionToSetDto(Collection<Category> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

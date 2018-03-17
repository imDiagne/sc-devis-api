package com.devis.service;

import java.io.IOException;
import java.util.List;

import com.devis.service.dto.CategoryDto;

public interface ICategoryService {

	/**
	 * Create a User DTO
	 * @param category
	 * @return
	 * @throws IOException 
	 */
	CategoryDto create(CategoryDto category) throws IOException;
	
	/**
	 * 
	 * @param category
	 * @return
	 */
	CategoryDto update(CategoryDto category);
	
	/**
	 * Find Category By Id
	 * @param id
	 * @return
	 */
	CategoryDto findById(Long id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	CategoryDto findByCategoryNumber(Long id);
	
	/**
	 * 
	 * @return
	 */
	List<CategoryDto> findAll();
	
	/**
	 * 
	 * @return
	 */
	List<CategoryDto> findByMultipleCriteriaSearch();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Boolean isExist(Integer id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Boolean deleteById (Long id);
}

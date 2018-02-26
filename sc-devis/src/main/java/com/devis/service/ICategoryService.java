package com.devis.service;

import java.util.List;

import com.devis.service.dto.CategoryDto;

public interface ICategoryService {

	/**
	 * Create a User DTO
	 * @param category
	 * @return
	 */
	CategoryDto create(CategoryDto category);
	
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
}

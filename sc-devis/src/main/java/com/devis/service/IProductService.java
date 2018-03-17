package com.devis.service;

import com.devis.service.dto.ProductDto;

public interface IProductService {

	/**
	 * Create a Product DTO
	 * @param productDto
	 * @return
	 */
	ProductDto create(ProductDto productDto);
	
	/**
	 * 
	 * @param productDto
	 * @return
	 */
	ProductDto update(ProductDto productDto);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ProductDto findById(Long id);
	
	/**
	 * @param id
	 * @return
	 */
	Boolean isExist(Integer id);
	
}

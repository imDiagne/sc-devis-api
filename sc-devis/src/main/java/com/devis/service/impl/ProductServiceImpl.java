package com.devis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devis.service.IProductService;
import com.devis.service.dto.ProductDto;

@Service
public class ProductServiceImpl implements IProductService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	// @Autowired
	// private IP
	
	@Override
	public ProductDto create(ProductDto productDto) {	
		return null;
	}

	@Override
	public ProductDto update(ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

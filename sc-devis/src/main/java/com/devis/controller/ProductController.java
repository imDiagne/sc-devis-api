package com.devis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devis.data.entity.Product;
import com.devis.service.IProductService;
import com.devis.service.dto.ProductDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
@Api(value = "product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductService service;
	
	/**
	 * Controller of creating a Product
	 * @param productFromView
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Create a Product", response = Product.class)
	public ResponseEntity<String> create(@RequestBody ProductDto productFromView) {
		LOGGER.info("Attempt to create a product");
		
		ProductDto productDtoCreated = service.create(productFromView);
		
		if (productDtoCreated != null) {
			LOGGER.info("Succesful creatin of an product, Product number : {}" +productDtoCreated.getId());
			return new ResponseEntity<>(productDtoCreated.getId().toString(), HttpStatus.CREATED);
		} else {
			LOGGER.info("Error creatin a Product");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

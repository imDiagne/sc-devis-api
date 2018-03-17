package com.devis.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devis.data.entity.Category;
import com.devis.service.ICategoryService;
import com.devis.service.dto.CategoryDto;
import com.devis.service.impl.SendMailTLS;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
@Api(value = "category")
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	
	@SuppressWarnings("unused")
	@Autowired
	private SendMailTLS sendMailTLS;
	
	@Autowired
	private ICategoryService service;
	
	/**
	 * Create a category and subCategory
	 * @param categoryDto
	 * @return categoryDto created
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Create a category", response = Category.class)
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) throws IOException {
		LOGGER.info("Attempt to create an Category");
		
		CategoryDto categoryDtoCreated = service.create(categoryDto);
		
		if (categoryDtoCreated != null) {
			LOGGER.info("Successful Creating of an Category, Category number : {}" + categoryDtoCreated.getId());
			return new ResponseEntity<>(categoryDtoCreated, HttpStatus.CREATED);
		} else {
			LOGGER.info("Error creatin a Category");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Update an category", response = Category.class)
	public ResponseEntity<CategoryDto> update (@RequestBody CategoryDto categoryDto) {
		LOGGER.info("Attempt to update an Category");
		
		CategoryDto categoryDtoToUpdate = service.update(categoryDto);
		
		/**
		 * Establish the different controls and defnie categoryException 
		 */
		if (categoryDtoToUpdate != null) {
			LOGGER.info("Successful updating an Category, Category number : {}" + categoryDtoToUpdate.getId());
			return new ResponseEntity<>(categoryDtoToUpdate, HttpStatus.CREATED);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param id to retrieve
	 * @return a CategoryDto
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDto> getById(@PathVariable("idCategory") Long id) {
		CategoryDto categoryDto = service.findById(id);
		if (categoryDto != null) {
			return new ResponseEntity<>(categoryDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * @param id of category to delete
	 * @return true if delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
		LOGGER.info("Attempt to delete an Category");
		
		Boolean result = service.deleteById(id);
		if (result) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * TODO : 
	 * Write the update method
	 * Write getSubCategoriesByMainCategoryID
	 * Write getCategoryByCategoryNumber
	 */
	
/*
	@RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value=" Mail")
	public ResponseEntity<String> sendSimpleMessage() {
		sendMailTLS.sendMessageWithTemplaye();
		return null;
	}*/
	
	/*
	@RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value=" Mail")
	public ResponseEntity<String> sendMessageWithAttachment(Boolean noImp) {
		sendMailTLS.sendMessageWithTemplaye();
		return null;
	}*/
	
	
}
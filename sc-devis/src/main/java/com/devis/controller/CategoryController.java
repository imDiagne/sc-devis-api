package com.devis.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devis.data.entity.Category;
import com.devis.service.dto.CategoryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
@Api(value = "category")
public class CategoryController {

	@RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Create Users", response = Category.class)
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
		return null;
	}
}
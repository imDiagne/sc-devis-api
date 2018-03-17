package com.devis.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
    private String categoryNumber;
	
	private String description;
	
	private Long mainCategoryID;
	 
	private List<CategoryDto> subCategory;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(String categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getMainCategoryID() {
		return mainCategoryID;
	}

	public void setMainCategoryID(Long mainCategoryID) {
		this.mainCategoryID = mainCategoryID;
	}

	public List<CategoryDto> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<CategoryDto> subCategory) {
		this.subCategory = subCategory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

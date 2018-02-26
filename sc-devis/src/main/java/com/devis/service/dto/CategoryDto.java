package com.devis.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.devis.data.entity.Category;

public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String categoryNumber;
	
	private String description;
	
	// @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	// @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	private LocalDateTime dateCreate;
	
	private LocalDateTime dateModification;
	
	// Recursion
	private Long CategoryId;
	
	// Recursion
	// private List<CategoryDto> ListCategory;

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

	public LocalDateTime getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDateTime dateCreate) {
		this.dateCreate = dateCreate;
	}

	public LocalDateTime getDateModification() {
		return dateModification;
	}

	public void setDateModification(LocalDateTime dateModification) {
		this.dateModification = dateModification;
	}

	public Long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}

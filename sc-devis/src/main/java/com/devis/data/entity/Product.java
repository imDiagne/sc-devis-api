package com.devis.data.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"CATEGORY\"")
public class Product {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "\"ID\"")
	private Long id;
	
	@Column(name = "\"PRODUCT_NUMBER\"")
	private String productNumber;
	
	@Column(name = "\"LABEL\"")
	private String label;
	
	@Column(name = "\"DESCRIPTION\"")
	private String description;
	
	@Column(name = "\"COMMERCIALIZATION_START_DATE\"")
	private LocalDateTime commercializationStartDate;
	
	@Column(name = "\"COMMERCIALIZATION_END_DATE\"")
	private LocalDateTime commercializationENdDate;
	
	// Mapping between Category and Product
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "\"FK_ID_CATEGORY\"")
	private Category category;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCommercializationStartDate() {
		return commercializationStartDate;
	}

	public void setCommercializationStartDate(LocalDateTime commercializationStartDate) {
		this.commercializationStartDate = commercializationStartDate;
	}

	public LocalDateTime getCommercializationENdDate() {
		return commercializationENdDate;
	}

	public void setCommercializationENdDate(LocalDateTime commercializationENdDate) {
		this.commercializationENdDate = commercializationENdDate;
	}

	
	
	
}

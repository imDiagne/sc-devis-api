package com.devis.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String productNumber;
	
	private String label;
	
	private String description;
	
	// @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	// @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	private LocalDateTime commercializationStartDate;
	
	// @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	// @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	private LocalDateTime commercializationENdDate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}

package com.devis.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"CATEGORY\"")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "\"ID\"")
	private Long id;
	
	@Column(name = "\"CATEGORY_NUMBER\"")
	private String categoryNumber;
	
	@Column(name = "\"DESCRIPTION\"")
	private String description;
	
	// Recursion 
	@ManyToOne
	@JoinColumn(name = "\"FK_ID_PARENT_CATEGORY\"")
	private Category mainCategory;
	
	// Recursion
	@OneToMany(mappedBy = "mainCategory", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Category> subCategory;
	
	/*******/
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public Category getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(Category mainCategory) {
		this.mainCategory = mainCategory;
	}

	public List<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}
	
	
}


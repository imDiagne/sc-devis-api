package com.devis.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name = "\"DATE_CREATE\"")
	private LocalDateTime dateCreate;
	
	@Column(name = "\"DATE_MODIFICATION\"")
	private LocalDateTime dateModification;
	
	/**
	 * Recursive Parent Child relationship in JPA 
	 */
	
	// Recursion
	@ManyToOne
	@JoinColumn(name = "\"FK_ID_CATEGORY\"")
	private Category category;
	
	// Recursion
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    List<Category > categoryList = new ArrayList<Category>();

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}


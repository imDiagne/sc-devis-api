package com.devis.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devis.data.entity.Category;

public interface ICategoryDao extends JpaRepository<Category, Long> {

}

package com.devis.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devis.data.dao.ICategoryDao;
import com.devis.data.entity.Category;
import com.devis.service.ICategoryService;
import com.devis.service.dto.CategoryDto;
import com.devis.service.mapper.CategoryMapper;

/**
 * 
 * @author ibrahimamadiodiodiagne
 *
 */

@Service
public class CategoryServiceImpl implements ICategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryMapper mapper;

	@Autowired
	private ICategoryDao dao;
	
	@Autowired
	private ICategoryService service;
	
	@Override
	public CategoryDto create(CategoryDto categoryFromView) throws IOException {
		/**
		 * We remind that a category can have childs and a category can also parent
		 * We have a recursive mapping. we can have a category with a list of subCatégories
		 * or a category linked to an existant category. 
		 */
		// Create a list of Category
		List<CategoryDto> subCategoriesDto = new ArrayList<>();
		
		// Recover the list of subCategories
		if (categoryFromView.getSubCategory() != null) {
			categoryFromView.getSubCategory().forEach(item -> subCategoriesDto.add(item));
		}
		
		Category categoryToSaveInDB = mapper.convertToEntity(categoryFromView);
		
		// We check if the the category is linked and eventually verified the category linked eixst 
		if (dao.exists(categoryFromView.getMainCategoryID()) || categoryFromView.getMainCategoryID() == 0){
			categoryToSaveInDB.setMainCategory(dao.findOne(categoryFromView.getMainCategoryID()));
			categoryToSaveInDB.getSubCategory().clear();
			CategoryDto categoryDtoSaved = mapper.convertToDto(dao.save(categoryToSaveInDB));
			
			/**
			 * If the list of subCategories is not empty
			 * We go through this list and save each subCategories in DB
			 */
			if (!subCategoriesDto.isEmpty()) {
				
				subCategoriesDto.forEach(item -> item.setMainCategoryID(categoryDtoSaved.getId()));
				
					subCategoriesDto.forEach(item -> {
						try {
							service.create(item);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
			}
			categoryDtoSaved.setSubCategory(subCategoriesDto);
			return categoryDtoSaved;
		}
		LOGGER.info("The category linked is not present in DB");
		return null;
	}



	@Override
	public CategoryDto update(CategoryDto category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto findById(Long idCategory) {
		Category categoryEntity = dao.findOne(idCategory);
		if (categoryEntity != null) {
			CategoryDto result = mapper.convertToDto(categoryEntity);
			return result;
		}
		return null;
	}

	@Override
	public CategoryDto findByCategoryNumber(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> findByMultipleCriteriaSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean deleteById(Long idCategory) {
		Category categortyEntity = dao.findOne(idCategory);
		if (categortyEntity != null) {
			dao.delete(categortyEntity);
			return true;
		} else {
			LOGGER.info("Delete Category by iD  : not found");
			return false;
		}
	}

}

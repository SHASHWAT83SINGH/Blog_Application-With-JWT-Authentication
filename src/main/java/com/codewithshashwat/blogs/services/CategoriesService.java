package com.codewithshashwat.blogs.services;

import java.util.List;


import com.codewithshashwat.blogs.payloads.CategoriesDto;


public interface CategoriesService {

	// CREATE
	public CategoriesDto createCategories(CategoriesDto categoriesDto);

	// UPDATE
	public CategoriesDto updateCategories(CategoriesDto categoryDto, Integer categoryId);

	// DELETE
	public void deleteCategories(Integer categoryId);

	// GET
	public CategoriesDto getCategories(Integer categoryId);

	// GET_ALLcategory
	List<CategoriesDto> getall();
}

//PUBLIC acess modifier lagane ki jarurat nhi hai it will automatically take the modifer as public
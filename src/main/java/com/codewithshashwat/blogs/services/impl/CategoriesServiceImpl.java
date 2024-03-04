package com.codewithshashwat.blogs.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithshashwat.blogs.entities.Categories;
import com.codewithshashwat.blogs.exceptions.ResourceNotFoundException;
import com.codewithshashwat.blogs.payloads.CategoriesDto;
import com.codewithshashwat.blogs.repositories.CategoriesRepo;
import com.codewithshashwat.blogs.services.CategoriesService;
@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesRepo categoriesRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoriesDto createCategories(CategoriesDto categoriesDto) {
		// TODO Auto-generated method stub
		Categories cat = this.mapper.map(categoriesDto, Categories.class);
		Categories addedCat = this.categoriesRepo.save(cat);
		return this.mapper.map(addedCat, CategoriesDto.class);
	}

	@Override
	public CategoriesDto updateCategories(CategoriesDto categoriesDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Categories cat = this.categoriesRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
		cat.setCategoryTitle(categoriesDto.getCategoryTitle());
		cat.setCategoryDescription(categoriesDto.getCategoryDescription());
		Categories updatecat = this.categoriesRepo.save(cat);
		return this.mapper.map(updatecat, CategoriesDto.class);
	}

	@Override
	public void deleteCategories(Integer categoryId) {
		// TODO Auto-generated method stub
		Categories cat = this.categoriesRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Categories", "category_Id", categoryId));
		this.categoriesRepo.delete(cat);
	}

	@Override
	public CategoriesDto getCategories(Integer categoryId) {
		// TODO Auto-generated method stub
		Categories cat = this.categoriesRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("categories", "categoried__id", categoryId));
		return this.mapper.map(cat, CategoriesDto.class);
	}

	@Override
	public List<CategoriesDto> getall() {
		// TODO Auto-generated method stub
		List<Categories> categories = this.categoriesRepo.findAll();
		List<CategoriesDto>catDtos = categories.stream().map((cat)-> this.mapper.map(cat,CategoriesDto.class)).collect(Collectors.toList());
		 return catDtos;
	}

}

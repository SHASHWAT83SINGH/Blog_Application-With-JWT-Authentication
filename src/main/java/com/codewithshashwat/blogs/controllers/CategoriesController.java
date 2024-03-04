package com.codewithshashwat.blogs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithshashwat.blogs.payloads.ApiResponse;
import com.codewithshashwat.blogs.payloads.CategoriesDto;
import com.codewithshashwat.blogs.services.CategoriesService;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;

	// Create
	@PostMapping("/")
	public ResponseEntity<CategoriesDto> createCategories(@RequestBody CategoriesDto categoriesDto) {
		CategoriesDto createCategories = this.categoriesService.createCategories(categoriesDto);
		return new ResponseEntity<CategoriesDto>(createCategories, HttpStatus.CREATED);

	}

	// UPDATE
	@PutMapping("/{catId}")
	public ResponseEntity<CategoriesDto> updateCategories(@RequestBody CategoriesDto categoryDto,
			@PathVariable Integer catId) {
		CategoriesDto updateCategories = this.categoriesService.updateCategories(categoryDto, catId);
		return new ResponseEntity<CategoriesDto>(updateCategories, HttpStatus.OK);

	}

	// DELETE
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategories(@PathVariable Integer catId) {
		this.categoriesService.deleteCategories(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);

	}

	// GET
	@GetMapping("/{catId}")
	public ResponseEntity<CategoriesDto> getCategories(@PathVariable Integer catId) {
		CategoriesDto categoriesDto = this.categoriesService.getCategories(catId);
		return new ResponseEntity<CategoriesDto>(categoriesDto, HttpStatus.OK);
	}

	// GET_ALL

	@GetMapping("/")
	public ResponseEntity<List<CategoriesDto>> getall() {
		List<CategoriesDto> categories = this.categoriesService.getall();
		return ResponseEntity.ok(categories);
	}
}

package com.codewithshashwat.blogs.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriesDto {

	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;
	
}

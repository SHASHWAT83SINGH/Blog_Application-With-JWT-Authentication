package com.codewithshashwat.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithshashwat.blogs.entities.Categories;

public interface CategoriesRepo extends JpaRepository<Categories, Integer>
{

}

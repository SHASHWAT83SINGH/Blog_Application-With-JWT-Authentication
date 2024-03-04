package com.codewithshashwat.blogs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithshashwat.blogs.entities.Categories;
import com.codewithshashwat.blogs.entities.Post;
import com.codewithshashwat.blogs.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	
	  List<Post> getAllPostByUser(User user); 
	  List<Post>getAllPostByCategories(Categories categories);
	  List<Post> findByUser(User user); 
	 List<Post> findByCategories(Categories categories);
	 List<Post> findByTitleContaining(String Title);
	 
	 

}


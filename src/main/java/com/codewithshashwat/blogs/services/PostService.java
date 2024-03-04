package com.codewithshashwat.blogs.services;

import java.util.List;

import com.codewithshashwat.blogs.entities.Post;
import com.codewithshashwat.blogs.payloads.PostDto;
import com.codewithshashwat.blogs.payloads.PostResponse;

public interface PostService {

	//CREATE
	
	 PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//UPDATE
	 PostDto updatePost(PostDto postDto,Integer postId);
	 
	 //DELETE
	 void deletePost(Integer postId);
	 
	 //GET_ALL_POST
	  PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy);
	 
	 //GET_SINGLE_POST
	 PostDto getPostById(Integer postId);
	 
	 //GET_ALL_POST BY CATEGORY
	 List<PostDto> getPostByCategory(Integer categoryId);
	 
	 //GET_ALL_POST BY USER
	 List<PostDto> getPostByUser(Integer userId);
	 
	 //Search Posts
	 List<PostDto> searchPost(String keyword);
}
package com.codewithshashwat.blogs.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithshashwat.blogs.entities.Categories;
import com.codewithshashwat.blogs.entities.Post;
import com.codewithshashwat.blogs.entities.User;
import com.codewithshashwat.blogs.exceptions.ResourceNotFoundException;
import com.codewithshashwat.blogs.payloads.PostDto;
import com.codewithshashwat.blogs.payloads.PostResponse;
import com.codewithshashwat.blogs.repositories.CategoriesRepo;
import com.codewithshashwat.blogs.repositories.PostRepo;
import com.codewithshashwat.blogs.repositories.UserRepo;
import com.codewithshashwat.blogs.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper model;
	@Autowired
	private CategoriesRepo categoriesRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

		Categories categories = this.categoriesRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("categories", "categoryId", categoryId));

		Post post = this.model.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategories(categories);
		post.setUser(user);

		Post newPost = this.postRepo.save(post);
		return this.model.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "post_Id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepo.save(post);

		return this.model.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "post_Id", postId));
		this.postRepo.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {

		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
		Page<Post> pagePost = this.postRepo.findAll(p);

		List<Post> allposts = pagePost.getContent();
		List<PostDto> postDtos = allposts.stream().map((post) -> this.model.map(post, PostDto.class))
				.collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPage(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());

		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));

		return this.model.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Categories categories = this.categoriesRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("categories", "categoryId", categoryId));
		List<Post> posts = this.postRepo.findByCategories(categories);
		List<PostDto> postDtos = posts.stream().map(post -> this.model.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User users = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		List<Post> posts = this.postRepo.findByUser(users);
		List<PostDto> postDtouse = posts.stream().map(post -> this.model.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtouse;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post> posts = this.postRepo.findByTitleContaining(keyword);
		List<PostDto> postDto = posts.stream().map((post) -> this.model.map(posts, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

}

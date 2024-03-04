package com.codewithshashwat.blogs.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.codewithshashwat.blogs.entities.Categories;
import com.codewithshashwat.blogs.entities.Comment;
import com.codewithshashwat.blogs.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostDto {

	private Integer postId;
	
	private String title;

	private String content;

	private String imageName = "default.png";

	private Date addedDate;

	private CategoriesDto categories;

	private UserDto users;
	
	private Set<CommentDto> comments= new HashSet<>();

}

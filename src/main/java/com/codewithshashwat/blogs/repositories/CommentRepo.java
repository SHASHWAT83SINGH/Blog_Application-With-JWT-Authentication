package com.codewithshashwat.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithshashwat.blogs.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> 
{

}

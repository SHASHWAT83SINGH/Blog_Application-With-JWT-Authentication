package com.codewithshashwat.blogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codewithshashwat.blogs.payloads.ApiResponse;
import com.codewithshashwat.blogs.payloads.CommentDto;
import com.codewithshashwat.blogs.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
	@Autowired
	private CommentService commentService;

	
	// Creating Comment
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId) {

		CommentDto createcomment = this.commentService.createcomment(comment, postId);
		return new ResponseEntity<CommentDto>(createcomment, HttpStatus.CREATED);
	}

	//Deleting Comment
	@PostMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteCommment(@PathVariable Integer commentId) {

		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted Successfully !!", true), HttpStatus.OK);

	}

}

package com.codewithshashwat.blogs.services;

import com.codewithshashwat.blogs.payloads.CommentDto;

public interface CommentService {
	
	
	//Creating Comment
	CommentDto createcomment(CommentDto commentDto,Integer PostId);

	//deleteComment
	void deleteComment(Integer commentId);
}

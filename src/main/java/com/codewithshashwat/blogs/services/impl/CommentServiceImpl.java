package com.codewithshashwat.blogs.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codewithshashwat.blogs.entities.Comment;
import com.codewithshashwat.blogs.entities.Post;
import com.codewithshashwat.blogs.exceptions.ResourceNotFoundException;
import com.codewithshashwat.blogs.payloads.CommentDto;
import com.codewithshashwat.blogs.repositories.CommentRepo;
import com.codewithshashwat.blogs.repositories.PostRepo;
import com.codewithshashwat.blogs.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper model;

	@Override
	public CommentDto createcomment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		// Comment ko pane ke liye hume usse comment class me
		// nikalna hoga that's why we have used modelMapper here.
		Comment comment = this.model.map(commentDto, Comment.class);

		// Comment ko post me pass kardenge taki wo usmme use ho jaye
		comment.setPost(post);

		// Uske Badd comment ko save kardenge repo me.
		Comment savedcomment = this.commentRepo.save(comment);

		return this.model.map(savedcomment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));
		this.commentRepo.delete(com);

	}

}

package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Comment;
import com.example.demo.request.CommentRequest;

public interface CommentService {

	List<Comment> findAllComments();
	
	Comment saveOrUpdateComment(CommentRequest request);
	
	void delete(Long commentId);
}

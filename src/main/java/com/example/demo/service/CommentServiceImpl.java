package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.request.CommentRequest;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired 
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> findAllComments() {
		List<Comment> comments = commentRepository.findAllByParentCommentIsNull();
		return comments;
	}

	@Override
	public Comment saveOrUpdateComment(CommentRequest request) {
		Date currDate = new Date();
		Comment comment = null;
		if(Objects.isNull(request.getCommentId())) {
			comment = new Comment();
			comment.setUserId(request.getUserId());
			comment.setComment(request.getComment());
			comment.setCreatedDate(currDate);
		} else {
			Optional<Comment> commentOpt = commentRepository.findById(request.getCommentId());
			if(commentOpt.isPresent()) comment = commentOpt.get();
			comment.setUserId(request.getUserId());
			comment.setComment(request.getComment());
			comment.setCreatedDate(currDate);
		}
		
		if(Objects.nonNull(request.getParentCommentId())) {
			Optional<Comment> parentComment = commentRepository.findById(request.getParentCommentId());
			parentComment.ifPresent(comment::setParentComment);
		}
		
		comment.setLastUpdatedDate(currDate);
		return commentRepository.save(comment);
	}

	@Override
	public void delete(Long commentId) {
		commentRepository.deleteById(commentId);
	}

}

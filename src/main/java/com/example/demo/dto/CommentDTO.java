package com.example.demo.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CommentDTO {

	private long commentId;
	
	private long userId;
	
	private String comment;
	
	private Date createdDate;
	
	private Date lastUpdatedDate;
	
	@JsonBackReference
    private CommentDTO parentComment;
 
    private Set<CommentDTO> subComments;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public CommentDTO getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentDTO parentComment) {
		this.parentComment = parentComment;
	}

	public Set<CommentDTO> getSubComments() {
		return subComments;
	}

	public void setSubComments(Set<CommentDTO> subComments) {
		this.subComments = subComments;
	}
    
    
}

package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {

	List<Comment> findAllByParentCommentIsNull();
}

package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Comment;
import com.example.demo.request.CommentRequest;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping(path="/demo")
public class MainController {

	@Autowired
	private CommentService commentService;

	@GetMapping(path="/comments")
	public @ResponseBody List<Comment> comments () {
		return commentService.findAllComments(); 
	}

	@PostMapping(path="/comment/add")
	public @ResponseBody Comment addComment(@RequestBody CommentRequest commentRequest) {
		return commentService.saveOrUpdateComment(commentRequest);
	}
	
	@PostMapping(path="/comment/udpate")
	public @ResponseBody Comment updateComment(@RequestBody CommentRequest commentRequest) {
		return commentService.saveOrUpdateComment(commentRequest);
	}
	
	@PostMapping(path="/comment/delete/{commentId}")
	public @ResponseBody String delete(@PathVariable Long commentId) {
		commentService.delete(commentId);
		return "deleted";
	}
}

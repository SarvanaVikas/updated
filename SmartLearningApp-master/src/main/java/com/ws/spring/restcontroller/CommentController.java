package com.ws.spring.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ws.spring.model.Comment;

import com.ws.spring.service.CommentServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/comment")
@Api(value = "Comment Management System", tags = "Operations pertaining to Comment in Comment Management System")
public class CommentController {
	
	@Autowired
	CommentServiceImpl commentService;
	
	@PostMapping("/v1/createComment")
	ResponseEntity<String> createComment(@RequestBody Comment comment) {
		Comment commentCreated = commentService.createComment(comment);
		return ResponseEntity.created(URI.create("/comment/v1/queryCommentById/" + commentCreated.getCommentId())).body("");
	}

	@PostMapping("/v1/updateComment")
	ResponseEntity<String> updateComment(@RequestBody Comment comment) {
		Comment commentCreated = commentService.updateComment(comment);
		return ResponseEntity.created(URI.create("comment/v1/queryCommentById/" + commentCreated.getCommentId())).body("");
	}

	@GetMapping("/v1/queryCommentById/{id}")
	ResponseEntity<Comment> queryCommentById(@PathVariable long id) {
		Comment comment = commentService.queryCommentById(id);
		return ResponseEntity.ok().body(comment);
	}

	
	
	@DeleteMapping("/v1/deleteCommentById/{id}")
	ResponseEntity<Comment> deleteCommentById(@PathVariable long id) {
		Comment comment = commentService.deleteCommentById(id);
		return ResponseEntity.ok().body(comment);
	}

	

	@GetMapping("/v1/queryAllComments")
	ResponseEntity<List<Comment>> queryAllComments() {
		List<Comment> comments = commentService.queryAllComments();
		return ResponseEntity.ok().body(comments);
	}


	

}

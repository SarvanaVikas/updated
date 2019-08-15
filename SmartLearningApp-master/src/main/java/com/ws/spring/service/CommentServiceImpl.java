package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Comment;
import com.ws.spring.repository.CommentRepository;

@Service
public class CommentServiceImpl {
	
	@Autowired
	CommentRepository commentRepository;
	

	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public Comment updatePost(Comment comment) {
		return commentRepository.save(comment);
	}

	public Comment queryCommentById(long id) {
		return commentRepository.findCommentByCommentId(id);
	}
	
	
	public Comment deleteCommentById(long id) {
		return commentRepository.deleteCommentByCommentId(id);
	}
	



	public List<Comment> queryAllComments() {
		return commentRepository.findAll();
	}

	public Comment updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}



}

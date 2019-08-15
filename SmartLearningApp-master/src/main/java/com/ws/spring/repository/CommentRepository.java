package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Comment;


@Repository
public interface CommentRepository   extends JpaRepository<Comment, Long>{
	
	Comment findCommentByCommentId(long commentId);
	
	
	
	Comment deleteCommentByCommentId(long commentId);
	

}

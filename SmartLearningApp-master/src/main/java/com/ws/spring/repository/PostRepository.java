package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Post;




@Repository
public interface PostRepository   extends JpaRepository<Post, Long>{
	
	Post findPostByPostId(long postId);
	
	Post findPostByTag(String tag);
	
	Post deletePostByPostId(long postId);
	
	

}

package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Post;
import com.ws.spring.repository.PostRepository;


@Service
public class PostServiceImpl {
	
	@Autowired
	PostRepository postRepository;

	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	public Post updatePost(Post post) {
		return postRepository.save(post);
	}

	public Post queryPostById(long id) {
		return postRepository.findPostByPostId(id);
	}
	
	
	public Post deletePostById(long id) {
		return postRepository.deletePostByPostId(id);
	}
	
	public Post queryPostByTag(String tag) {
		return postRepository.findPostByTag(tag);
		}


	public List<Post> queryAllPosts() {
		return postRepository.findAll();
	}

}

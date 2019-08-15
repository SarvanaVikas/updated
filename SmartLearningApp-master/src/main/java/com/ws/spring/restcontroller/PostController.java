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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.spring.model.Post;
import com.ws.spring.service.PostServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/post")
@Api(value = "Post Management System", tags = "Operations pertaining to Post in Post Management System")
public class PostController {
	
	@Autowired
	PostServiceImpl postService;
	
	@PostMapping("/v1/createPost")
	ResponseEntity<String> createPost(@RequestBody Post post) {
		Post postCreated = postService.createPost(post);
		return ResponseEntity.created(URI.create("/post/v1/queryPostById/" + postCreated.getPostId())).body("");
	}

	@PostMapping("/v1/updatePost")
	ResponseEntity<String> updatePost(@RequestBody Post post) {
		Post postCreated = postService.updatePost(post);
		return ResponseEntity.created(URI.create("post/v1/queryPostById/" + postCreated.getPostId())).body("");
	}

	@GetMapping("/v1/queryPostById/{id}")
	ResponseEntity<Post> queryPostById(@PathVariable long id) {
		Post post = postService.queryPostById(id);
		return ResponseEntity.ok().body(post);
	}

	@GetMapping("/v1/queryPostByTag")
	ResponseEntity<Post> queryPostByTag(@RequestParam("tag") String tag) {
		Post post = postService.queryPostByTag(tag);
		return ResponseEntity.ok().body(post);
	}
	
	@DeleteMapping("/v1/deletePostById/{id}")
	ResponseEntity<Post> deletePostById(@PathVariable long id) {
		Post post = postService.deletePostById(id);
		return ResponseEntity.ok().body(post);
	}

	

	@GetMapping("/v1/queryAllPosts")
	ResponseEntity<List<Post>> queryAllPosts() {
		List<Post> posts = postService.queryAllPosts();
		return ResponseEntity.ok().body(posts);
	}


}

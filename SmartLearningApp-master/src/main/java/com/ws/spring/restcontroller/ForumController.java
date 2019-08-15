package com.ws.spring.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.spring.model.Forum;
import com.ws.spring.service.ForumServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/forum")
@Api(value = "Forum Management System", tags = "Operations pertaining to Forum in Forum Management System")

public class ForumController {
	
	@Autowired
	ForumServiceImpl forumService;

	@PostMapping("/v1/createForum")
	ResponseEntity<String> createForum(@RequestBody Forum forum) {
		Forum forumCreated = forumService.createForum(forum);
		return ResponseEntity.created(URI.create("/forum/v1/queryForumById/" + forumCreated.getForumId())).body("");
	}

	@PostMapping("/v1/updateForum")
	ResponseEntity<String> updateForum(@RequestBody Forum forum) {
		Forum forumCreated = forumService.updateForum(forum);
		return ResponseEntity.created(URI.create("/forum/v1/queryForumById/" + forumCreated.getForumId())).body("");
	}

	@GetMapping("/v1/queryForumById/{id}")
	ResponseEntity<Forum> queryForumByForumId(@PathVariable long forumId) {
		Forum forum = forumService.queryForumByForumId(forumId);
		return ResponseEntity.ok().body(forum);
	}

	@GetMapping("/v1/queryForumByForumName")
	ResponseEntity<Forum> queryForumByForumName(@RequestParam("forumName") String forumName) {
		Forum forum = forumService.queryForumByForumName(forumName);
		return ResponseEntity.ok().body(forum);
	}

	@GetMapping("/v1/queryForumByAccessLevel")
	ResponseEntity<Forum> queryForumByAccessLevel(@RequestParam("accessLevel") long accessLevel) {
		Forum forum = forumService.queryForumByAccessLevel(accessLevel);
		return ResponseEntity.ok().body(forum);
	}

	@GetMapping("/v1/queryAllForums")
	ResponseEntity<List<Forum>> queryAllForums() {
		List<Forum> forums = forumService.queryAllForums();
		return ResponseEntity.ok().body(forums);
	}



}

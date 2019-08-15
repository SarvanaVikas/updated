package com.ws.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.Forum;
import com.ws.spring.repository.ForumRepository;

@Service
public class ForumServiceImpl {
	
	
	@Autowired
	ForumRepository forumRepository;

	public Forum createForum(Forum forum) {
		return forumRepository.save(forum);
	}

	public Forum updateForum(Forum forum) {
		return forumRepository.save(forum);
	}

	public Forum queryForumByForumId(long forumId) {
		return forumRepository.findForumByForumId(forumId);
	}
	public Forum queryForumByForumName(String forumName) {
		return forumRepository.findForumByForumName(forumName);
	}

	public Forum queryForumByAccessLevel(long accessLevel) {
		return forumRepository.findForumByAccessLevel(accessLevel);
	}

	public List<Forum> queryAllForums() {
		return forumRepository.findAll();
	}



}

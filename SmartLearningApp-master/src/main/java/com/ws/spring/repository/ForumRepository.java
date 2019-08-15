package com.ws.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.Forum;
	
	@Repository
	public interface ForumRepository  extends JpaRepository<Forum, String>{
		
		Forum findForumByForumId(long forumId);
		
		Forum findForumByForumName(String forumName);
		
		Forum findForumByAccessLevel(long accessLevel);

}

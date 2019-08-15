package com.ws.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;


@Entity
@Table(name = "t_ws_forum")
@DynamicUpdate
@Data
public class Forum {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long forumId;

	@Column(unique = true)
	private String forumName;

	private String description;

	private String  listofpost;
	
	private int status;

	private long accessLevel;

	public String getForumId() {
		// TODO Auto-generated method stub
		return null;
		}
	
	@OneToOne(targetEntity=Group.class)
	private  Group group;

		
	
}

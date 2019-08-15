
package com.ws.spring.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "t_ws_post")
@DynamicUpdate
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	
	private String tag;
	
	@CreationTimestamp
	private LocalDateTime insertedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;
	
	
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="parent_post_id")
	private Post parentPost;
	
	@OneToMany(mappedBy="parentPost")
	private Set<Post> subPost = new HashSet<Post>();
	
	@OneToOne
	@JoinColumn(name="post_id")
	private Comment comment;
	
	



}

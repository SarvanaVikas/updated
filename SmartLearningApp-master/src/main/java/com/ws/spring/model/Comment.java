package com.ws.spring.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "t_ws_comment")
@DynamicUpdate
@Data

public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	
private String comment;
	
	@CreationTimestamp
	private LocalDateTime insertedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;
	
	@OneToOne
	@JoinColumn(name="post_id")
	
	private Post post;

}

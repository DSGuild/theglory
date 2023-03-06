package com.project.theglory.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="reply")
@NoArgsConstructor
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyId;
	private String content;
	private LocalDateTime createdAt;
	private Integer deleteYn;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Builder
	public Reply(Long replyId, String content, LocalDateTime createdAt, Integer deleteYn, Post post, User user) {
		this.replyId = replyId;
		this.content = content;
		this.createdAt = createdAt;
		this.deleteYn = deleteYn;
		this.post = post;
		this.user = user;
	}
	
	
}

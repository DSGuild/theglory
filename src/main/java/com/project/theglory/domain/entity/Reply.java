package com.project.theglory.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="reply")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyId;
	private String content;
	@CreatedDate
	private LocalDateTime createdAt;
	private Integer deleteYn;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@PrePersist
	public void prePersist() {
		this.deleteYn = this.deleteYn == null ? 0 : this.deleteYn;
	}

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

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
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="post_story")
@NoArgsConstructor
public class PostStory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postStoryId;
	private String content;
	private Integer episode;
	
	@CreatedDate
	private LocalDateTime createdAt;
		
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Builder
	public PostStory(Long postStoryId, String content, Integer episode, LocalDateTime createdAt, User user) {
		this.postStoryId = postStoryId;
		this.content = content;
		this.episode = episode;
		this.createdAt = createdAt;
		this.user = user;
	}
}

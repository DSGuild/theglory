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
@Table(name="post_character")
@NoArgsConstructor
public class PostCharacter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postCharacterId;
	private String content;
	private Integer characterCode;
	
	@CreatedDate
	private LocalDateTime createdAt;
		
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Builder
	public PostCharacter(Long postCharacterId, String content, Integer characterCode, LocalDateTime createdAt, User user) {
		this.postCharacterId = postCharacterId;
		this.content = content;
		this.characterCode = characterCode;
		this.createdAt = createdAt;
		this.user = user;
	}
}

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
@Table(name="quiz_log")
@NoArgsConstructor
public class QuizLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quizLogId;
	private Integer level;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
//	@LastModifiedDate
//	private LocalDateTime updatedAt;
	
	private Integer score;
	private Integer passYn;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Builder
	public QuizLog(Long quizLogId, Integer level, LocalDateTime createdAt, Integer score, Integer passYn, User user) {
		this.quizLogId = quizLogId;
		this.level = level;
		this.createdAt = createdAt;
		this.score = score;
		this.passYn = passYn;
		this.user = user;
	}
	
}

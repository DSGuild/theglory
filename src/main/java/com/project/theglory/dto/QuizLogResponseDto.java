package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.QuizLog;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuizLogResponseDto {
	
	private Long quizLogId;
	private Integer level;
	private LocalDateTime createdAt;
	private Integer score;
	private Integer passYn;
	private Long userId;
	
	@Builder
	public QuizLogResponseDto(QuizLog entity) {
		this.quizLogId = entity.getQuizLogId();
		this.level = entity.getLevel();
		this.createdAt = entity.getCreatedAt();
		this.score = entity.getScore();
		this.passYn = entity.getPassYn();
		this.userId = entity.getUser().getUserId();
	}
	

}

package com.project.theglory.dto;

import com.project.theglory.domain.entity.QuizLog;
import com.project.theglory.domain.entity.User;

import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuizLogRequestDto {
	
	private Long quizLogId;
	private Integer level;
	private Integer season;
	private Integer score;
	private Integer passYn;
	private Long userId;
	
	@Builder
	public QuizLogRequestDto(Long quizLogId, Integer level, Integer season, Integer score, Integer passYn, User user, Long userId) {
		this.quizLogId = quizLogId;
		this.level = level;
		this.season = season;
		this.score = score;
		this.passYn = passYn;
		this.userId = userId;
	}
	
	public QuizLog toEntity() {
		return QuizLog.builder()
				.quizLogId(quizLogId)
				.level(level)
				.season(season)
				.score(score)
				.passYn(passYn)
				.user(User.builder().userId(userId).build())
				.build();
	}
}

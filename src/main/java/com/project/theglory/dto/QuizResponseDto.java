package com.project.theglory.dto;

import com.project.theglory.domain.entity.Quiz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuizResponseDto {
	
	private Long quizId;
	private Integer level;
	private String image;
	private String question;
	private String selectOne;
	private String selectTwo;
	private String selectThree;
	private String selectFour;
	private Integer answer;
	
	@Builder
	public QuizResponseDto(Quiz entity) {
		this.quizId = entity.getQuizId();
		this.level = entity.getLevel();
		this.image = entity.getImage();
		this.question = entity.getQuestion();
		this.selectOne = entity.getSelectOne();
		this.selectTwo = entity.getSelectTwo();
		this.selectThree = entity.getSelectThree();
		this.selectFour = entity.getSelectThree();
		this.selectFour = entity.getSelectFour();
		this.answer = entity.getAnswer();
	}

}

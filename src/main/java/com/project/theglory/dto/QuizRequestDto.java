package com.project.theglory.dto;

import com.project.theglory.domain.entity.Quiz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuizRequestDto {
	
	private Integer level;
	
	@Builder 
	public QuizRequestDto(Quiz entity) {
		this.level = entity.getLevel();
	}

}

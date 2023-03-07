package com.project.theglory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.domain.entity.Quiz;
import com.project.theglory.dto.QuizResponseDto;
import com.project.theglory.service.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/quiz")
@RequiredArgsConstructor
public class QuizController {
	
	final private QuizService quizService;
	
	// API요청받으면 퀴즈 15개 랜덤으로 쿼리로 받아서 던져주려고함.(테스트중)
	@GetMapping("/{level}")
	public List<QuizResponseDto> getQuizs(@PathVariable Integer level) {
		List<Quiz> quizs = quizService.getQuizs(level);
		List<QuizResponseDto> responses = new ArrayList<QuizResponseDto>(level);
		for (Quiz q : quizs) {
			responses.add(QuizResponseDto.builder().entity(q).build());
		}
		return responses;
	}

}

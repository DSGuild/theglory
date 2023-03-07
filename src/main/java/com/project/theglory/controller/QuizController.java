package com.project.theglory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.domain.entity.Quiz;
import com.project.theglory.domain.entity.QuizLog;
import com.project.theglory.dto.QuizLogRequestDto;
import com.project.theglory.dto.QuizLogResponseDto;
import com.project.theglory.dto.QuizResponseDto;
import com.project.theglory.service.QuizLogService;
import com.project.theglory.service.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/quiz")
@RequiredArgsConstructor
public class QuizController {
	
	final private QuizService quizService;
	final private QuizLogService quizLogService;
	
	@GetMapping("/{level}")
	public List<QuizResponseDto> getQuizs(@PathVariable Integer level) {
		List<Quiz> quizs = quizService.getQuizs(level);
		List<QuizResponseDto> responses = new ArrayList<QuizResponseDto>(level);
		for (Quiz q : quizs) {
			responses.add(QuizResponseDto.builder().entity(q).build());
		}
		return responses;
	}
	
	// TODO: QuizLog Create
	@PostMapping("/log")
	public void createQuizLog(@RequestBody QuizLogRequestDto quizLogRequestDto) {
		QuizLog quizLog = quizLogRequestDto.toEntity();
		quizLogService.createQuizLog(quizLog);
	}
	
	// TODO: QuizLog Get
//	@GetMapping("/log/{userId}")
	
}

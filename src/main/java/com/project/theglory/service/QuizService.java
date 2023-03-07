package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.Quiz;
import com.project.theglory.domain.repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizService {
	
	final private QuizRepository quizRepository;
	
	public List<Quiz> getQuizs(Integer level) {
		return quizRepository.getQuizs(level);
	}

}

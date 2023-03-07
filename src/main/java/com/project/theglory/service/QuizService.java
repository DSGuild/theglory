package com.project.theglory.service;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizService {
	
	final private QuizRepository quizRepository;

}

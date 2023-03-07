package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.QuizLog;
import com.project.theglory.domain.repository.QuizLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizLogService {
	
	private final QuizLogRepository quizLogRepository;
	
	public QuizLog getQuizLog(Long id) {
		return quizLogRepository.findById(id).orElse(null);
	}
	
	public void createQuizLog(QuizLog quizLog) {
		quizLogRepository.save(quizLog);
	}
	
	public List<QuizLog> getQuizLogs(Long id) {
		return quizLogRepository.getQuizLogsByUserId(id);
	}
}

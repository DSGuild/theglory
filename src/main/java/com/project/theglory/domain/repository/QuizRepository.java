package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.theglory.domain.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	
	@Query(value = "SELECT * FROM quiz Q WHERE Q.level = ?1 ORDER BY RAND() LIMIT 15", nativeQuery= true)
	List<Quiz> getQuizs(Integer level);
}

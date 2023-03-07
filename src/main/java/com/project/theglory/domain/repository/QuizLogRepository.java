package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.theglory.domain.entity.QuizLog;

public interface QuizLogRepository extends JpaRepository<QuizLog, Long>{
	
	@Query("select q from QuizLog q where q.user.userId = ?1")
	List<QuizLog> getQuizLogsByUserId(Long id);

	void save(Long userId);

}

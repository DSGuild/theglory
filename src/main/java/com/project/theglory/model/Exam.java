package com.project.theglory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="exam")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long examId;
	
	@Column(name = "season")
	private Integer season;
	
	@Column(name = "level")
	private Integer level;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@Column(name = "quiz_list")
	private String quizList;
	
	@Column(name = "answer_list")
	private String answerList;
	
	@Column(name = "user_written")
	private String userWritten;
	
	@Column(name = "correct")
	private Integer correct;
	
	@Column(name = "pass_yn")
	private boolean passYn;

}

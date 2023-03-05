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
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	
	@Column(name = "title")
	private String title;
	 
	@Column(name = "content")
	private String content;
	
	@Column(name = "select_one")
	private String selectOne;
	
	@Column(name = "select_two")
	private String selectTwo;
	
	@Column(name = "select_three")
	private String selectThree;
	
	@Column(name = "select_four")
	private String selectFour;
	
	@Column(name = "question_img")
	private String questionImg;
	
	@Column(name = "correct_num")
	private int correctNum;
	
	@Column(name = "question_level")
	private int questionLevel;

}

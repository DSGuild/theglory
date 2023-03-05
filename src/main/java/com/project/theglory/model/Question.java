package com.project.theglory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "season")
	private Integer season;
	
	@Column(name = "level")
	private Integer level;
	
	@Column(name = "quiz")
	private Integer quiz;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "select_one")
	private String selectOne;
	
	@Column(name = "select_two")
	private String selectTwo;
	
	@Column(name = "select_three")
	private String selectThree;
	
	@Column(name = "select_four")
	private String selectFour;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "out_num")
	private Integer outNum;
	
	@Column(name = "correct_num")
	private Integer correctNum;

}

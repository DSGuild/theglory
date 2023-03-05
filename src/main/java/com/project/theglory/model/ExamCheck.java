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
@Table(name="examcheck")
public class ExamCheck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long examCheckId;
	
	@Column(name = "season")
	private Integer season;
	
	@Column(name = "level")
	private Integer level;
	
	@Column(name = "sign_up")
	private Integer signUp;
	
	@Column(name = "pass")
	private Integer pass;
	
	

}

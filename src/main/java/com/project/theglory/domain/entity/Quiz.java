package com.project.theglory.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="quiz")
@NoArgsConstructor
// 문제은행 데이터베이스 Entity.
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quizId;
	private Integer level;
	private String image;
	private String question;
	private String selectOne;
	private String selectTwo;
	private String selectThree;
	private String selectFour;
	private Integer answer;
	
	@Builder
	public Quiz(Long quizId, Integer level, String image, String question, String selectOne, String selectTwo, String selectThree, String selectFour, Integer answer) {
		this.quizId =quizId;
		this.level = level;
		this.image = image;
		this.question = question;
		this.selectOne = selectOne;
		this.selectTwo = selectTwo;
		this.selectThree = selectThree;
		this.selectFour = selectFour;
		this.answer = answer;
		
	}
}

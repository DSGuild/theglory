package com.project.theglory.model;

import java.time.LocalDateTime;

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
@Table(name="favorite")
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long favoriteId;
	
	// Post - Favorite Join 확인 완료(230305 - Crane)
	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;
	
	// User - Favorite Join 확인 완료(230305 - Crane)
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;

}

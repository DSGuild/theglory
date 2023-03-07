package com.project.theglory.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="user")
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userNm;
	private String profile;
	
	@OneToMany(mappedBy = "user")
	private List<Favorite> favorities;

	@Builder
	public User(Long userId, String userNm, String profile, List<Favorite> favorities) {
		this.userId = userId;
		this.userNm = userNm;
		this.profile = profile;
		this.favorities = favorities;
	}
	
}

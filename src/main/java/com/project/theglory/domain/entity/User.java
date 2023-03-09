package com.project.theglory.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String email;
	private String userNm;
	private String profile;
	@CreatedDate
	private LocalDateTime createdAt;
	private int badge1;
	private int badge2;
	private int episode;
	
	@OneToMany(mappedBy = "user")
	private List<Favorite> favorities;

	@Builder
	public User(Long userId, String email, String userNm, String profile, LocalDateTime createdAt, int badge1,
			int badge2, int episode, List<Favorite> favorities) {
		super();
		this.userId = userId;
		this.email = email;
		this.userNm = userNm;
		this.profile = profile;
		this.createdAt = createdAt;
		this.badge1 = badge1;
		this.badge2 = badge2;
		this.episode = episode;
		this.favorities = favorities;
	}

}

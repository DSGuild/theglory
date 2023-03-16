package com.project.theglory.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
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
	private Integer badge1;
	private Integer badge2;
	private Integer episode;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Favorite> favorities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<PostVote> postVotes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<UserVote> userVotes;
	
	@PrePersist
	public void prePersist() {
		this.badge1 = this.badge1 == null ? 0 : this.badge1;
		this.badge2 = this.badge2 == null ? 0 : this.badge2;
		this.episode = this.episode == null ? 0 : this.episode;
	}

	@Builder
	public User(Long userId, String email, String userNm, String profile, LocalDateTime createdAt, Integer badge1, Integer badge2, Integer episode, List<Favorite> favorities) {
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

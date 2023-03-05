package com.project.theglory.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "id", unique = true)
	private String id;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "user_nm")
	private String userNm;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;
	
	@Column(name = "profile_img")
	private String profileImg;
	
	@Column(name = "badge")
	private Integer badge;
	
	@Column(name = "episode")
	private Integer episode;
	
    // 테이블 조인 	
	@OneToMany(mappedBy = "user")
	private List<Favorite> favorite;
	
	@OneToMany(mappedBy = "user")
	private List<Reply> reply;
	
	@OneToMany(mappedBy = "user")
	private List<UserPoll> userPoll;
	
	@OneToMany(mappedBy = "user")
	private List<Post> post;
	
	@OneToMany(mappedBy = "user")
	private List<Exam> exam;
	
}

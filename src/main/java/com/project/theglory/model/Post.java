package com.project.theglory.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "category")
	private Integer category;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name = "delete_yn")
	private boolean deleteYn;
	
	@Column(name = "episode")
	private Integer episode;
	
	@Column(name = "likes")
	private Integer likes;
	
	
	// 테이블 조인 
	@OneToMany(mappedBy = "post")
	private List<Favorite> favorite;
	
	@OneToMany(mappedBy = "post")
	private List<Reply> reply;
	
	@OneToMany(mappedBy = "post")
	private List<UserPoll> userPoll;
	
	@OneToMany(mappedBy = "post")
	private List<PostGeneral> postGeneral;
	
	@OneToMany(mappedBy = "post")
	private List<Postpoll> postPoll;
	
	@OneToMany(mappedBy = "post")
	private List<PostCharacter> postCharacter;
	
	@OneToMany(mappedBy = "post")
	private List<PostStory> postStory;
}

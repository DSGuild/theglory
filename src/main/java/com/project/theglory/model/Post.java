package com.project.theglory.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn // 하위 테이블의 구분 컬럼 생성(default = DTYPE)
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
	private Integer deleteYn;
	
	@Column(name = "episode")
	private Integer episode;
	
	@Column(name = "likes")
	private Integer likes;
	
	
//	// 테이블 조인 
//	@OneToMany(mappedBy = "post")
//	private List<Favorite> favorite;
//	
//	@OneToMany(mappedBy = "post")
//	private List<Reply> reply;
//	
//	@OneToMany(mappedBy = "post")
//	private List<UserPoll> userPoll;
//	
//	@OneToMany(mappedBy = "post")
//	private List<PostGeneral> postGeneral;
//	
//	@OneToMany(mappedBy = "post")
//	private List<PostPoll> postPoll;
//	
//	@OneToMany(mappedBy = "post")
//	private List<PostCharacter> postCharacter;
//	
//	@OneToMany(mappedBy = "post")
//	private List<PostStory> postStory;
}

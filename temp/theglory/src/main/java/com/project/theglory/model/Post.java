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
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "likes")
	private String likes;
	
	@Column(name = "is_delete")
	private String isDelete;
	
	@Column(name = "vote_count")
	private String voteCount;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "delete_date") 
	private LocalDateTime deleteDate;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "episode_select")
	private int episodeSelect;
	
	@OneToMany(mappedBy = "post")
	private List<Favorite> favorite;
	
	@OneToMany(mappedBy = "post")
	private List<Reply> reply;
	
	@OneToMany(mappedBy = "post")
	private List<Vote> vote;
}

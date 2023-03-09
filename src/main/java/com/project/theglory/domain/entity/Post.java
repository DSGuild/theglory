package com.project.theglory.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="post")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	private String title;
	private String content;
	@CreatedDate
	private LocalDateTime createdAt;
	private Integer deleteYn;
	private Integer episode;
	private Integer favorite;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "post")
	private List<Favorite> favorities;
	
	@OneToMany(mappedBy = "post")
	private List<Reply> replies;
	
	@PrePersist
	public void prePersist() {
		this.deleteYn = this.deleteYn == null ? 0 : this.deleteYn;
		this.favorite = this.favorite == null ? 0 : this.favorite;
	}

	@Builder
	public Post(Long postId, String title, String content, LocalDateTime createdAt, Integer deleteYn, Integer episode,
		Integer favorite, User user) {
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.deleteYn = deleteYn;
		this.episode = episode;
		this.favorite = favorite;
		this.user = user;
	}
	
}

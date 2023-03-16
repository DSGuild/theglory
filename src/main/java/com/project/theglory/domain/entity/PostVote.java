package com.project.theglory.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "post_vote")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class PostVote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postVoteId;
	private String title;
	private Integer total;
	@CreatedDate
	private LocalDateTime createdAt;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "postVote")
	private List<Vote> votes;
	
	@Builder
	public PostVote(Long postVoteId, String title, Integer total, LocalDateTime createdAt, User user) {
		this.postVoteId = postVoteId;
		this.title = title;
		this.total = total;
		this.createdAt = createdAt;
		this.user = user;
	}
	
	public void plusTotal() {
		this.total++;
	}
}

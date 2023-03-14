package com.project.theglory.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "vote")
@NoArgsConstructor
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long voteId;
	private String content;
	private Integer count;
	
	@ManyToOne
	@JoinColumn(name = "post_vote_id")
	private PostVote postVote;
	
	@PrePersist
	public void prePersist() {
		this.count = this.count == null ? 0 : this.count;
	}
	
	@Builder
	public Vote(Long voteId, String content, Integer count, PostVote postVote) {
		this.voteId = voteId;
		this.content = content;
		this.count = count;
		this.postVote = postVote;
	}
}

package com.project.theglory.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="user_vote")
@NoArgsConstructor
public class UserVote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userVoteId;
	
	@ManyToOne
	@JoinColumn(name = "vote_id")
	private Vote vote;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Builder
	public UserVote(Long userVoteId, Vote vote, User user) {
		this.userVoteId = userVoteId;
		this.vote = vote;
		this.user = user;
	}

}

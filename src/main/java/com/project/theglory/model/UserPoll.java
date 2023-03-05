package com.project.theglory.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user_poll")
public class UserPoll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userPollId;
	
	// UserVote - Post Join 확인 (230305 - Crane)
	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;
	
	// UserVote - User Join 확인 (230305 - Crane)
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	// UserVote - VoteSelection 확인 (230305 - Crane)
	@ManyToOne
	@JoinColumn(name = "poll_selection")
	private PollSelection pollSelection;
	
	@Column(name = "poll_at")
	private LocalDateTime pollAt;

}

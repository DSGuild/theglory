package com.project.theglory.dto;

import com.project.theglory.domain.entity.User;
import com.project.theglory.domain.entity.UserVote;
import com.project.theglory.domain.entity.Vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserVoteResponseDto {
	
	private Long userVoteId;
	private Vote vote;
	private User user;
	
	@Builder
	public UserVoteResponseDto(UserVote entity) {
		this.userVoteId = entity.getUserVoteId();
		this.vote = entity.getVote();
		this.user = entity.getUser();
	}
}

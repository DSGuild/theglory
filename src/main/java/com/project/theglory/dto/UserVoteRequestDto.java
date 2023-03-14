package com.project.theglory.dto;

import com.project.theglory.domain.entity.UserVote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserVoteRequestDto {
	
	private Long userVoteId;
	private Long voteId;
	private Long userId;
	
	@Builder
	public UserVoteRequestDto(Long userVoteId, Long voteId, Long userId) {
		this.userVoteId = userVoteId;
		this.voteId = voteId;
		this.userId = userId;
	}
	
	public UserVote toEntity() {
		return UserVote.builder()
				.build();
	}

}

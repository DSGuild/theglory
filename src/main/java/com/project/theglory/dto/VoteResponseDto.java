package com.project.theglory.dto;

import com.project.theglory.domain.entity.PostVote;
import com.project.theglory.domain.entity.Vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteResponseDto {
	private Long voteId;
	private String content;
	private Integer count;
//	private PostVote postVote;
	
	@Builder
	public VoteResponseDto(Vote entity) {
		this.voteId = entity.getVoteId();
		this.content = entity.getContent();
		this.count = entity.getCount();
//		this.postVote = entity.getPostVote();
	}

}

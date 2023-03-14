package com.project.theglory.dto;

import com.project.theglory.domain.entity.PostVote;
import com.project.theglory.domain.entity.Vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteRequestDto {
	
	private Long voteId;
	private String content;
	private Integer count;
	private Long postVoteId;
	
	@Builder 
	public VoteRequestDto(Long voteId, String content, Integer count, Long postVoteId) {
		this.voteId = voteId;
		this.content = content;
		this.count = count;
		this.postVoteId = postVoteId;
	}
	
	public Vote toEntity() {
		return Vote.builder()
				.voteId(postVoteId)
				.content(content)
				.count(count)
				.postVote(PostVote.builder().postVoteId(postVoteId).build())
				.build();
	}

}

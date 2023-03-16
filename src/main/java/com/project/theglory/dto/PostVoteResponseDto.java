package com.project.theglory.dto;

import java.util.List;

import com.project.theglory.domain.entity.PostVote;
import com.project.theglory.domain.entity.User;
import com.project.theglory.domain.entity.Vote;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Getter
@NoArgsConstructor
public class PostVoteResponseDto {
	
	private Long postVoteId;
	private String title;
	private Integer total;
	private User user;
	private List<Vote> votes;
	
	@Builder
	public PostVoteResponseDto(PostVote entity) {
		this.postVoteId = entity.getPostVoteId();
		this.title = entity.getTitle();
		this.total = entity.getTotal();
		this.user = entity.getUser();
		this.votes = entity.getVotes();
	}
	
}

package com.project.theglory.dto;

import com.project.theglory.domain.entity.PostVote;
import com.project.theglory.domain.entity.User;

import lombok.Builder;

public class PostVoteRequestDto {
	
	private Long postVoteId;
	private String title;
	private Integer total;
	private Long userId;
	
	@Builder
	public PostVoteRequestDto(Long postVoteId, String title, Integer total, Long userId) {
		this.postVoteId = postVoteId;
		this.title = title;
		this.total = total;
		this.userId = userId;		
	}
	
	public PostVote toEntity() {
		return PostVote.builder()
				.postVoteId(postVoteId)
				.title(title)
				.total(total)
				.user(User.builder().userId(userId).build())
				.build();
	}
}

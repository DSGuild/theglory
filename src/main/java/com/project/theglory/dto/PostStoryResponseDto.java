package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.PostStory;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostStoryResponseDto {
	private Long postStoryId;
	private String content;
	private Integer episode;
	private LocalDateTime createdAt;
	private Long userId;
	
	@Builder
	public PostStoryResponseDto(PostStory entity) {
		this.postStoryId = entity.getPostStoryId();
		this.content = entity.getContent();
		this.episode = entity.getEpisode();
		this.createdAt = entity.getCreatedAt();
		this.userId = entity.getUser().getUserId();
	}
	
}
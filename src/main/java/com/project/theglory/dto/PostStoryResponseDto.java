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
	private Integer badge1;
	private Integer badge2;
	private String userNm;
	
	@Builder
	public PostStoryResponseDto(PostStory entity) {
		this.postStoryId = entity.getPostStoryId();
		this.content = entity.getContent();
		this.episode = entity.getEpisode();
		this.createdAt = entity.getCreatedAt();
		this.badge1 = entity.getUser().getBadge1();
		this.badge2 = entity.getUser().getBadge2();
		this.userNm = entity.getUser().getUserNm();
	}
	
}
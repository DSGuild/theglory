package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.PostStory;
import com.project.theglory.domain.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostStoryRequestDto {
	private Long postStoryId;
	private String content;
	private Integer episode;
	private LocalDateTime createdAt;
	private Long userId;
	
	@Builder 
	public PostStoryRequestDto(Long postStoryId, String content, Integer episode, LocalDateTime createdAt, Long userId) {
		this.postStoryId = postStoryId;
		this.content = content;
		this.episode = episode;
		this.createdAt = createdAt;
		this.userId = userId;		
	}
	
	public PostStory toEntity() {
		return PostStory.builder()
				.postStoryId(postStoryId)
				.content(content)
				.episode(episode)
				.createdAt(createdAt)
				.user(User.builder().userId(userId).build())
				.build();
	}

}

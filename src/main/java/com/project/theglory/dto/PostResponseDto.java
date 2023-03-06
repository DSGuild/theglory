package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
	private Long postId;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private Integer episode;
	private Integer favorite;
	private Long userId;
	private String userNm;
	private String profile;
	
	@Builder
	public PostResponseDto(Post entity) {
		this.postId = entity.getPostId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.createdAt = entity.getCreatedAt();
		this.episode = entity.getEpisode();
		this.favorite = entity.getFavorite();
		this.userId = entity.getUser().getUserId();
		this.userNm = entity.getUser().getUserNm();
		this.profile = entity.getUser().getProfile();
	}
}

package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class PostRequestDto {
	
	private Long postId;
	private String title;
	private String content;
	private Integer deleteYn;
	private Integer episode;
	private Integer favorite;
	private Long userId;
	
	@Builder
	public PostRequestDto(Long postId, String title, String content, Integer deleteYn, Integer episode, Integer favorite, Long userId) {
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.deleteYn = deleteYn;
		this.episode = episode;
		this.favorite = favorite;
		this.userId = userId;
	}
	
	public Post toEntity() {
		return Post.builder()
				.postId(postId)
				.title(title)
				.content(content)
				.deleteYn(deleteYn)
				.episode(episode)
				.favorite(favorite)
				.user(User.builder().userId(userId).build())
				.build();
	}
	
}

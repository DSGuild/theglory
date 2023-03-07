package com.project.theglory.dto;

import com.project.theglory.domain.entity.Favorite;
import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FavoriteRequestDto {
	private Long favoriteId;
	private Post post;
	private User user;
	
	@Builder
	public FavoriteRequestDto(Long favoriteId, Post post, User user) {
		this.favoriteId = favoriteId;
		this.post = post;
		this.user = user;
	}
	
	public Favorite toEntity() {
		return Favorite.builder()
				.favoriteId(favoriteId)
				.post(post)
				.user(user)
				.build();
	}
}

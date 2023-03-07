package com.project.theglory.dto;

import com.project.theglory.domain.entity.Favorite;
import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FavoriteResponseDto {
	private Long favoriteId;
	private Post post;
	private User user;
	
	@Builder
	public FavoriteResponseDto(Favorite entity) {
		this.favoriteId = entity.getFavoriteId();
		this.post = entity.getPost();
		this.user = entity.getUser();
	}
}

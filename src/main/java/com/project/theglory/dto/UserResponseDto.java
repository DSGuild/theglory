package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
	private Long userId;
	private String email;
	private String userNm;
	private String profile;
	private LocalDateTime createdAt;
	private Integer badge1;
	private Integer badge2;
	private Integer episode;
	
	@Builder
	public UserResponseDto(User entity) {
		this.userId = entity.getUserId();
		this.email = entity.getEmail();
		this.userNm = entity.getUserNm();
		this.profile = entity.getProfile();
		this.createdAt = entity.getCreatedAt();
		this.badge1 = entity.getBadge1();
		this.badge2 = entity.getBadge2();
		this.episode = entity.getEpisode();
	}
}

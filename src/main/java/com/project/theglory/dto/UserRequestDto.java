package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
	private Long userId;
	private String email;
	private String userNm;
	private String profile;
	private int badge;
	private int episode;
	
	@Builder
	public UserRequestDto(Long userId, String email, String userNm, String profile, int badge,
			int episode) {
		super();
		this.userId = userId;
		this.email = email;
		this.userNm = userNm;
		this.profile = profile;
		this.badge = badge;
		this.episode = episode;
	}
	
	public User toEntity() {
		return User.builder()
				.userId(userId)
				.email(email)
				.userNm(userNm)
				.profile(profile)
				.badge(badge)
				.episode(episode)
				.build();
	}

}

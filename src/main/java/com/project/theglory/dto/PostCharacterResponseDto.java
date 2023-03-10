package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.PostCharacter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCharacterResponseDto {
	private Long postCharacterId;
	private String content;
	private Integer characterCode;
	private LocalDateTime createdAt;
	private Integer badge1;
	private Integer badge2;
	private String userNm;
	private String profile;
	
	@Builder
	public PostCharacterResponseDto(PostCharacter entity) {
		this.postCharacterId = entity.getPostCharacterId();
		this.content = entity.getContent();
		this.characterCode = entity.getCharacterCode();
		this.createdAt = entity.getCreatedAt();
		this.badge1 = entity.getUser().getBadge1();
		this.badge2 = entity.getUser().getBadge2();
		this.userNm = entity.getUser().getUserNm();
		this.profile = entity.getUser().getProfile();
	}
	
}
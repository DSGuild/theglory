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
	private Long userId;
	
	@Builder
	public PostCharacterResponseDto(PostCharacter entity) {
		this.postCharacterId = entity.getPostCharacterId();
		this.content = entity.getContent();
		this.characterCode = entity.getCharacterCode();
		this.createdAt = entity.getCreatedAt();
		this.userId = entity.getUser().getUserId();
	}
	
}
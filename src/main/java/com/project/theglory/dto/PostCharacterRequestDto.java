package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.PostCharacter;
import com.project.theglory.domain.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCharacterRequestDto {
	private Long postCharacterId;
	private String content;
	private Integer characterCode;
	private LocalDateTime createdAt;
	private Long userId;
	
	@Builder 
	public PostCharacterRequestDto(Long postCharacterId, String content, Integer characterCode, LocalDateTime createdAt, Long userId) {
//		this.postCharacterId = postCharacterId;
		this.content = content;
		this.characterCode = characterCode;
//		this.createdAt = createdAt;
		this.userId = userId;		
	}
	
	public PostCharacter toEntity() {
		return PostCharacter.builder()
//				.postCharacterId(postCharacterId)
				.content(content)
				.characterCode(characterCode)
//				.createdAt(createdAt)
				.user(User.builder().userId(userId).build())
				.build();
	}

}

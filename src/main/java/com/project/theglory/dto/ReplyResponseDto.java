package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyResponseDto {
	
	private Long replyId;
	private String content;
	private LocalDateTime createdAt;
	private Long userId;
	private String userNm;
	private String profile;
	private Integer badge1;
	private Integer badge2;

	@Builder
	public ReplyResponseDto(Reply entity) {
		this.replyId = entity.getReplyId();
		this.content = entity.getContent();
		this.createdAt = entity.getCreatedAt();
		this.userId = entity.getUser().getUserId();
		this.userNm = entity.getUser().getUserNm();
		this.profile = entity.getUser().getProfile();
		this.badge1 = entity.getUser().getBadge1();
		this.badge2 = entity.getUser().getBadge2();
	}
}

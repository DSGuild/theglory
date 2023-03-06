package com.project.theglory.dto;

import java.time.LocalDateTime;

import com.project.theglory.domain.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyRequestDto {
	private Long replyId;
	private String content;
	private Integer deleteYn;
	
	@Builder
	public ReplyRequestDto(Long replyId, String content, Integer deleteYn) {
		this.replyId = replyId;
		this.content = content;
		this.deleteYn = deleteYn;
	}
	
	public Reply toEntity() {
		return Reply.builder()
				.replyId(replyId)
				.content(content)
				.deleteYn(deleteYn)
				.build();
	}
}

package com.project.theglory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like {
	private String likeId;
	private String postId;
	private String userId;
	private String isLike;

}

package com.project.theglory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
	private String voteId;
	private String voteNum;
	private String image;
	private String text;
	private String postId;

}

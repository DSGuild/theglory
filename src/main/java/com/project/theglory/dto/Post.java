package com.project.theglory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	
	private String postId;
	private String category;
	private String title;
	private String content;
	private String likes;
	private String isDelete;
	private String voteCount;
	private String image;
	private String createDate;
	private String deleteDate;
	private String userId;
	private String episodeSelect;
	
	
}

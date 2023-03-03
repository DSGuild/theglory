package com.project.theglory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String id;
	private String userId;
	private String userNm;
	private String password;
	private String email;
	private String createdAt;
	private String updatedAt;
	private String deletedAt;
	
	
}

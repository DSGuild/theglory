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
	private String user_id;
	private String user_nm;
	private String password;
	private String email;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	
}

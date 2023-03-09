package com.project.theglory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.domain.entity.User;
import com.project.theglory.domain.repository.UserRepository;
import com.project.theglory.dto.UserRequestDto;
import com.project.theglory.dto.UserResponseDto;
import com.project.theglory.service.FavoriteService;
import com.project.theglory.service.PostService;
import com.project.theglory.service.ReplyService;
import com.project.theglory.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
	
	final private UserService userService;
	
	@GetMapping("/email")
	public UserResponseDto getUserByEmail(@RequestParam String email) {
		User user = userService.getUserByEmail(email);
		return UserResponseDto.builder().entity(user).build();
	}
	
	@PostMapping("")
	public void createUser(@RequestBody UserRequestDto userRequestDto) {
		User user = userRequestDto.toEntity();
		userService.createUser(user);
	}
}

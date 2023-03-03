package com.project.theglory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.dto.User;
import com.project.theglory.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {
	private final UserService userService;
	
	@GetMapping("/user")
	public List<User> user() {
		return userService.getUserList();
	}
	
}

package com.project.theglory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.model.User;
import com.project.theglory.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@Slf4j
public class UserController<userService> {
	private final UserService userService;
	
	@RequestMapping("/user")
	public User test() {
		log.debug("hi!");
		User user = userService.readUser(1L);
		return user;
	}
}

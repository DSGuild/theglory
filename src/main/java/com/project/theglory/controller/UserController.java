package com.project.theglory.controller;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.model.User;
import com.project.theglory.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController<userService> {
	private final UserService userService;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		return user;
	}
	
	@PostMapping("")
	public void createUser(@RequestBody User user) {
		Long id = user.getUserId();
		userService.createUser(id, user);
	}
	
	@PutMapping("")
	public User updateUser(@RequestBody User user) {
		Long id = user.getUserId();
		userService.updateUser(id, user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}

package com.project.theglory.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.model.Post;
import com.project.theglory.repository.PostRepository;
import com.project.theglory.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
	private final PostService postService;
	private final PostRepository postRepository;
	
	@GetMapping("")
	public Page<Post> getAllPosts(Integer Integer, Pageable pageable) {
		return postRepository.findByDeleteYn(Integer, pageable);
	}

}
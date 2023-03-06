package com.project.theglory.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.theglory.model.Post;
import com.project.theglory.model.PostCharacter;
import com.project.theglory.model.PostGeneral;
import com.project.theglory.model.PostPoll;
import com.project.theglory.model.PostStory;
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
	public Page<Post> getAllPosts(
//			@RequestParam(value="date") LocalDateTime date,
			Integer Integer, Pageable pageable) {
		return postRepository.findByDeleteYn(Integer, pageable);
	}
	
	@GetMapping("/{id}")
	public Post getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}
	
	@PostMapping("")
	public void createPost(@RequestBody Map<String, Object> map) {
		int category = (int)map.get("category");
		ObjectMapper objectMapper = new ObjectMapper();
		Post post;
		
		if (category == 1) post = objectMapper.convertValue(map, PostGeneral.class);
		else if (category == 2) post = objectMapper.convertValue(map, PostPoll.class);
		else if (category == 3) post = objectMapper.convertValue(map, PostCharacter.class);
		else post = objectMapper.convertValue(map, PostStory.class);
		
		postService.createPost(post);
	}
	
	@PutMapping("/{id}")
	public void updatePost(@PathVariable Long id, @RequestBody Map<String, Object> map) {
		Post dbPost = postService.getPost(id);
		
		int category = dbPost.getCategory();
		ObjectMapper objectMapper = new ObjectMapper();
		
		Post post;
		if (category == 1) post = objectMapper.convertValue(map, PostGeneral.class);
		else if (category == 2) post = objectMapper.convertValue(map, PostPoll.class);
		else if (category == 3) post = objectMapper.convertValue(map, PostCharacter.class);
		else post = objectMapper.convertValue(map, PostStory.class);
		
		post.setPostId(dbPost.getPostId());
		
		postService.updatePost(post);
	}
	
}
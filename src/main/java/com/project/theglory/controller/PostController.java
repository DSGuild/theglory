package com.project.theglory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;
import com.project.theglory.dto.PostRequestDto;
import com.project.theglory.dto.PostResponseDto;
import com.project.theglory.dto.ReplyResponseDto;
import com.project.theglory.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/post")
@RequiredArgsConstructor
public class PostController {
	
	final private PostService postService;

	@GetMapping("")
	public List<PostResponseDto> getPosts() {
		List<Post> posts = postService.getPosts();
		List<PostResponseDto> responses = new ArrayList<PostResponseDto>();
		for (Post p : posts) {
			responses.add(PostResponseDto.builder().entity(p).build()); 
		}
		return responses;
	}
	
	@GetMapping("/{id}")
	public PostResponseDto getPost(@PathVariable Long id) {
		Post post = postService.getPost(id);
		return PostResponseDto.builder().entity(post).build();
	}
	
	@PostMapping("")
	public void createPost(@RequestBody PostRequestDto postRequestDto) {
		Post post = postRequestDto.toEntity();
		postService.createPost(post);
	}
	
	// TODO: post관련 Update, Delete구문 작성해야 함.
	
	@GetMapping("/{id}/reply")
	public List<ReplyResponseDto> getReplies(@PathVariable Long id) {
		List<Reply> replies = postService.getReplies(id);
		List<ReplyResponseDto> responses = new ArrayList<ReplyResponseDto>();
		for (Reply r : replies) {
			responses.add(ReplyResponseDto.builder().entity(r).build()); 
		}
		return responses;
	}
	
}

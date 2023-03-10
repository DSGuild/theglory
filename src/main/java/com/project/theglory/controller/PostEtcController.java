package com.project.theglory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.domain.entity.PostCharacter;
import com.project.theglory.domain.entity.PostStory;
import com.project.theglory.dto.PostCharacterRequestDto;
import com.project.theglory.dto.PostCharacterResponseDto;
import com.project.theglory.dto.PostResponseDto;
import com.project.theglory.dto.PostStoryRequestDto;
import com.project.theglory.dto.PostStoryResponseDto;
import com.project.theglory.service.FavoriteService;
import com.project.theglory.service.PostCharacterService;
import com.project.theglory.service.PostService;
import com.project.theglory.service.ReplyService;
import com.project.theglory.service.PostStoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/post")
@RequiredArgsConstructor
public class PostEtcController {
	
	final private PostCharacterService postCharacterService;
	final private PostStoryService postStoryService;

	@GetMapping("/character")
	public List<PostCharacterResponseDto> getPostCharacters() {
		List<PostCharacter> postCharacters = postCharacterService.getPostCharacters();
		List<PostCharacterResponseDto> responses = new ArrayList<PostCharacterResponseDto>();
		for (PostCharacter c : postCharacters) {
			responses.add(PostCharacterResponseDto.builder().entity(c).build());
		}
		return responses;
	}
	
	@GetMapping("/character/{id}")
	public List<PostCharacterResponseDto> getPostCharacter(@PathVariable Long id) {
		List<PostCharacter> postCharacters = postCharacterService.getPostCharacter(id);
		List<PostCharacterResponseDto> responses = new ArrayList<PostCharacterResponseDto>();
		for (PostCharacter c : postCharacters) {
			responses.add(PostCharacterResponseDto.builder().entity(c).build());
		}
		return responses;
	}
	
	
	@PostMapping("/character")
	public void createPostCharacter(@RequestBody PostCharacterRequestDto postCharacterRequestDto) {
		PostCharacter postCharacter = postCharacterRequestDto.toEntity();
		postCharacterService.createPostCharacter(postCharacter);
	}
	
	@GetMapping("/story")
	public List<PostStoryResponseDto> getPostStories() {
		List<PostStory> postStories = postStoryService.getPostStories();
		List<PostStoryResponseDto> responses = new ArrayList<PostStoryResponseDto>();
		for (PostStory s : postStories) {
			responses.add(PostStoryResponseDto.builder().entity(s).build());
		}
		return responses;
	}
	
	@GetMapping("/story/{id}")
	public PostStoryResponseDto getPostStory(@PathVariable Long id) {
		PostStory postStory = postStoryService.getPostStory(id);
		return PostStoryResponseDto.builder().entity(postStory).build();
	}
	
	
	@PostMapping("/story")
	public void createPostStory(@RequestBody PostStoryRequestDto postStoryRequestDto) {
		PostStory postStory = postStoryRequestDto.toEntity();
		postStoryService.createPostStory(postStory);
	}
	
}

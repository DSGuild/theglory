package com.project.theglory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.PostStory;
import com.project.theglory.domain.repository.PostStoryRepository;
import com.project.theglory.dto.PostStoryResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostStoryService {
	
	final private PostStoryRepository postStoryRepository;
	
	public List<PostStoryResponseDto> getPostStory() {
		List<PostStory> postStories = postStoryRepository.findAll();
		List<PostStoryResponseDto> postStoryDtos = new ArrayList<>();
		for (PostStory postStory : postStories) {
			PostStoryResponseDto postStoryResponseDto = PostStoryResponseDto.builder()
					.entity(postStory)
					.build();
			postStoryDtos.add(postStoryResponseDto);
		}
		return postStoryDtos;
	}
	
	public List<PostStory> getPostStories() {
		return postStoryRepository.findAll();
	}
	
	public PostStory getPostStory(Long id) {
		return postStoryRepository.findById(id).orElse(null);
	}
	
	public void createPostStory(PostStory postStory) {
		postStoryRepository.save(postStory);
	}

}

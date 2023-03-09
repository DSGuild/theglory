package com.project.theglory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.PostCharacter;
import com.project.theglory.domain.repository.PostCharacterRepository;
import com.project.theglory.dto.PostCharacterResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostCharacterService {
	
	final private PostCharacterRepository postCharacterRepository;
	
	public List<PostCharacterResponseDto> getPostCharacter() {
		List<PostCharacter> postCharacters = postCharacterRepository.findAll();
		List<PostCharacterResponseDto> postCharacterDtos = new ArrayList<>();
		for (PostCharacter postCharacter : postCharacters) {
			PostCharacterResponseDto postCharacterResponseDto = PostCharacterResponseDto.builder()
					.entity(postCharacter)
					.build();
			postCharacterDtos.add(postCharacterResponseDto);
		}
		return postCharacterDtos;
	}
	
	public List<PostCharacter> getPostCharacters() {
		return postCharacterRepository.findAll();
	}
	
	public PostCharacter getPostCharacter(Long id) {
		return postCharacterRepository.findById(id).orElse(null);
	}
	
	public void createPostCharacter(PostCharacter postCharacter) {
		postCharacterRepository.save(postCharacter);
	}

}

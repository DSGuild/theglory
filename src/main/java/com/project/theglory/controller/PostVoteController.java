package com.project.theglory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.dto.PostVoteResponseDto;
import com.project.theglory.dto.VoteResponseDto;
import com.project.theglory.service.PostVoteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostVoteController {
	
	final private PostVoteService postVoteService;
	
	@GetMapping("/vote/all")
	public List<PostVoteResponseDto> getPostVotes() {
		List<PostVoteResponseDto> responses = postVoteService.getPostVotes();
		return responses;
	}
	
	@GetMapping("/vote/{postVoteId}")
	public List<VoteResponseDto> getVotes(@PathVariable Long postVoteId) {
		List<VoteResponseDto> responses;
		responses = postVoteService.getVotes(postVoteId);
		return responses;		
	}
	
	@PostMapping("/vote/{postVoteId}")
	public void createVote(@PathVariable Long postVoteId, @RequestParam Long userId, @RequestParam Long voteId) {
		postVoteService.createVote(postVoteId, userId, voteId);
	}
	

}

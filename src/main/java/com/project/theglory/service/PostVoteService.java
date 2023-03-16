package com.project.theglory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.PostVote;
import com.project.theglory.domain.entity.UserVote;
import com.project.theglory.domain.entity.Vote;
import com.project.theglory.domain.repository.PostVoteRepository;
import com.project.theglory.domain.repository.UserVoteRepository;
import com.project.theglory.domain.repository.VoteRepository;
import com.project.theglory.dto.PostVoteResponseDto;
import com.project.theglory.dto.VoteResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostVoteService {
	
	final private PostVoteRepository postVoteRepository;
	final private VoteRepository voteRepository;
	final private UserVoteRepository userVoteRepository;
	
	public List<PostVoteResponseDto> getPostVotes() {
		List<PostVote> postVotes = postVoteRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
		List<PostVoteResponseDto> postVoteResponseDtos = new ArrayList<>();
		for (PostVote postVote : postVotes) {
			PostVoteResponseDto postVoteResponseDto = PostVoteResponseDto.builder()
					.entity(postVote)
					.build();
			postVoteResponseDtos.add(postVoteResponseDto);
		}
		return postVoteResponseDtos;
	}
	
	public List<VoteResponseDto> getVotes(Long postVoteId) {
		List<Vote> votes = voteRepository.findAllByPostId(postVoteId);
		List<VoteResponseDto> voteResponseDtos = new ArrayList<>();
		for (Vote vote : votes) {
			VoteResponseDto voteResponseDto = VoteResponseDto.builder()
					.entity(vote)
					.build();
			voteResponseDtos.add(voteResponseDto);
		}
		return voteResponseDtos;
	}
	
	
	public PostVote getPostVote(Long id) {
		return postVoteRepository.findById(id).orElse(null);
	}
	
	public UserVote getUserVote(Long id) {
		return userVoteRepository.findById(id).orElse(null);
	}
	
	public Vote getVote(Long id) {
		return voteRepository.findById(id).orElse(null);
	}
	
	public void createPostVote(PostVote postVote) {
		postVoteRepository.save(postVote);
	}
	
	public void createUserVote(UserVote userVote) {
		userVoteRepository.save(userVote);
	}
	
	public void createVote(Long postVoteId, Long userId, Long voteId) {
		PostVote postVote = postVoteRepository.findById(postVoteId).orElse(null);
		postVote.plusTotal();
		// TODO
	}
	
}

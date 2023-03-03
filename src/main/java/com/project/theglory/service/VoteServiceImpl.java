package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.dao.VoteMapper;
import com.project.theglory.dto.Vote;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
	private final VoteMapper voteMapper;
	
	@Override
	public List<Vote> getVoteList() {
		return voteMapper.getVoteList();
	}

}

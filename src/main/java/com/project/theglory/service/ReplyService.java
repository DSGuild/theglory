package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.Reply;
import com.project.theglory.domain.repository.FavoriteRepository;
import com.project.theglory.domain.repository.PostRepository;
import com.project.theglory.domain.repository.ReplyRepository;
import com.project.theglory.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	
	final private ReplyRepository replyRepository;
	
	public List<Reply> getReplies(Long id) {
		return replyRepository.getRepliesByPostId(id);
	}
}

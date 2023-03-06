package com.project.theglory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.theglory.model.Post;
import com.project.theglory.model.Reply;
import com.project.theglory.repository.PostRepository;
import com.project.theglory.repository.ReplyRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ReplyService {
	
	private final ReplyRepository replyRepository;
	private final PostRepository postRepository;
	
	public Reply readReply(Long replyId) {
		Optional<Reply> reply = replyRepository.findById(replyId);
		if (reply.isPresent()) {
			return reply.get();
		}
		
		throw new EntityNotFoundException("Can't Find Any Replies.");
	}
	
	public void createReply(Reply reply) {
		replyRepository.save(reply);
	}
	
	public Reply getReply(Long id) {
		return replyRepository.findById(id).orElse(null);
		
	}
	
	public List<Reply> getReplies(Long postId) {
		Post post = postRepository.findById(postId).orElse(null);
		return post.getReply();
		
	}
	
	public void updateReply(Reply reply) {
		replyRepository.save(reply);
	}
	
}

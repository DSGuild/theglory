package com.project.theglory.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.theglory.model.Reply;
import com.project.theglory.repository.ReplyRepository;
import com.project.theglory.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/reply")
@RequiredArgsConstructor
@Slf4j
public class ReplyController {
	
	private final ReplyService replyService;
	private final ReplyRepository replyRepository;
	
	@GetMapping("")
	public Page<Reply> getAllPosts(
//			@RequestParam(value="date") LocalDateTime date,
			Integer Integer, Pageable pageable) {
		return replyRepository.findByDeleteYn(Integer, pageable);
	}
	
	@GetMapping("/{id}")
	public Reply getReply(@PathVariable Long id) {
		return replyService.getReply(id);
	}
	
	@PostMapping("")
	public void createReply(@RequestBody Map<String, Object> map) {		
		ObjectMapper objectMapper = new ObjectMapper();
		Reply reply;
		
		reply = objectMapper.convertValue(map, Reply.class);
		replyService.createReply(reply);		
	}
	
	@PutMapping("/{id}")
	public void updateReply(@PathVariable Long id, @RequestBody Map<String, Object> map) {
		Reply dbReply = replyService.getReply(id);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Reply reply;
		reply = objectMapper.convertValue(map, Reply.class);
		
		reply.setReplyId(dbReply.getReplyId());
		
		replyService.updateReply(reply);
	}
			
	
}
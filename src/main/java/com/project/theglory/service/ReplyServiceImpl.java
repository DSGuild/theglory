package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.dao.ReplyMapper;
import com.project.theglory.dto.Reply;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	private final ReplyMapper replyMapper;
	
	@Override
	public List<Reply> getReplyList() {
		return replyMapper.getReplyList();
	}

}

package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.dao.PostMapper;
import com.project.theglory.dto.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	private final PostMapper postMapper;
	
	@Override
	public List<Post> getPostList() {
		return postMapper.getPostList();
	}

}


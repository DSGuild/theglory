package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.dao.LikeMapper;
import com.project.theglory.dto.Like;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
	private final LikeMapper likeMapper;
	
	@Override
	public List<Like> getLikeList() {
		return likeMapper.getLikeList();
	}

}

package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.dao.UserMapper;
import com.project.theglory.dto.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	
	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
	}

}

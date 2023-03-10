package com.project.theglory.service;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.User;
import com.project.theglory.domain.repository.FavoriteRepository;
import com.project.theglory.domain.repository.PostRepository;
import com.project.theglory.domain.repository.ReplyRepository;
import com.project.theglory.domain.repository.UserRepository;
import com.project.theglory.dto.UserRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	final private UserRepository userRepository;
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	public void createUser(User user) {
		userRepository.save(user);
	}

	public void updateBadge(Long userId, int badge) {
//		userRepository.updateBadge(userId, badge);
	}

}

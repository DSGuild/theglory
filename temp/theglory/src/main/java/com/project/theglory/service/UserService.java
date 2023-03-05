package com.project.theglory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.theglory.model.User;
import com.project.theglory.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public User readUser(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
	
		throw new EntityNotFoundException("Can't find any user under given ID");
	}
}


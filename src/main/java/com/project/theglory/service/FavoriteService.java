package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.Favorite;
import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.User;
import com.project.theglory.domain.repository.FavoriteRepository;
import com.project.theglory.domain.repository.PostRepository;
import com.project.theglory.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoriteService {

	final private FavoriteRepository favoriteRepository;
	final private PostRepository postRepository;
	final private UserRepository userRepository;

	public void createFavorite(Long postId, Long userId) {
//		Favorite favorite = favoriteRepository.findByPostIdAndUserId(postId, userId);
//        return favoriteRepository.save(favorite);
	}

	public void deleteFavorite(Long postId, Long userId) {
		Post post = postRepository.findById(postId).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
//		favoriteRepository.deleteById(Favorite.builder().post(post).user(user).build());
	}
}

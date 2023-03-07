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

	public Favorite addFavorite(Post post, User user) {
        List<Favorite> favorites = favoriteRepository.findByPostAndUser(post, user);
        if (!favorites.isEmpty()) {
            throw new RuntimeException("Favorite already exists");
        }
        Favorite favorite = Favorite.builder().post(post).user(user).build();
        return favoriteRepository.save(favorite);
    }
	
	public void removeFavorite(Post post, User user) {
        favoriteRepository.deleteByPostAndUser(post, user);
    }
	
}

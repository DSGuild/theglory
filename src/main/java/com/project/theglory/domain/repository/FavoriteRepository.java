package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.theglory.domain.entity.Favorite;
import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
	
//	Favorite findByPostIdAndUserId(Long postId, Long userId);
//    
//    void deleteByPostAndUser(Long postId, Long userId);
}

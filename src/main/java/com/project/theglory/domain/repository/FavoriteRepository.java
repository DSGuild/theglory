package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.theglory.domain.entity.Favorite;
import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;
import com.project.theglory.domain.entity.User;

import jakarta.transaction.Transactional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

	List<Favorite> findByPostAndUser(Post post, User user);

	@Transactional
	void deleteByPostAndUser(Post post, User user);
	
}

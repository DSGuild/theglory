package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.theglory.domain.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("SELECT p, CASE WHEN f.id IS NULL THEN false ELSE true END as isLiked FROM Post p LEFT JOIN Favorite f ON p.id = f.post.id AND f.user.id = :userId")
    List<Object[]> findAllWithIsLikedByUser(@Param("userId") Long userId);
    
    @Query(value = "SELECT * FROM post ORDER BY favorite DESC, post_id DESC LIMIT 1", nativeQuery = true)
    Post orderByFavorite();    
}
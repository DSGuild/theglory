package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.theglory.domain.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
	
	@Query("select r from Reply r where r.post.postId = ?1")
	List<Reply> getRepliesByPostId(Long id);
}

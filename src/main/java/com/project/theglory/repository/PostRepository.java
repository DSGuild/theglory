package com.project.theglory.repository;

import com.project.theglory.model.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	Page<Post> findByDeleteYn(Integer deleteYn, Pageable pageable);

}

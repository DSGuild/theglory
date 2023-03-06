package com.project.theglory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theglory.model.Reply;
import com.project.theglory.model.Post;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	Page<Reply> findByDeleteYn(Integer deleteYn, Pageable pageable);
}

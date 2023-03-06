package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;

public interface PostRepository extends JpaRepository<Post, Long> {

}

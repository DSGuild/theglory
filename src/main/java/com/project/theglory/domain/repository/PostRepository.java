package com.project.theglory.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theglory.domain.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
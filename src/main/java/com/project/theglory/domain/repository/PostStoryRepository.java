package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theglory.domain.entity.PostStory;

public interface PostStoryRepository extends JpaRepository<PostStory, Long>{

	List<PostStory> findAllByEpisode(Long episode);


}

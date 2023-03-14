package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.theglory.domain.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	@Query(value = "SELECT * FROM vote WHERE post_vote_id = ?1", nativeQuery=true)
	List<Vote> findAllByPostId(Long postVoteId);

}

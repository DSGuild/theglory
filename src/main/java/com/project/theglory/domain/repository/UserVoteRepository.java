package com.project.theglory.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theglory.domain.entity.UserVote;

public interface UserVoteRepository extends JpaRepository<UserVote, Long>{

}

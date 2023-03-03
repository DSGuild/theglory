package com.project.theglory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.project.theglory.dto.Vote;

@Mapper
@Repository
public interface VoteMapper {
	
	List<Vote> getVoteList();

}

package com.project.theglory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.project.theglory.dto.User;

@Mapper
@Repository
public interface UserMapper {
	
	List<User> getUserList();

}

package com.project.theglory.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theglory.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

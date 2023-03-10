package com.project.theglory.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.theglory.domain.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	@Transactional
	@Modifying
	@Query("update User u set u.badge1 = ?2 where u.userId = ?1")
	void updateBadge1(Long userId, int badge);
	
	@Transactional
	@Modifying
	@Query("update User u set u.badge2 = ?2 where u.userId = ?1")
	void updateBadge2(Long userId, int badge);

}

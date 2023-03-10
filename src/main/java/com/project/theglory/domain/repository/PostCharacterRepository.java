package com.project.theglory.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.theglory.domain.entity.PostCharacter;

public interface PostCharacterRepository extends JpaRepository<PostCharacter, Long>{

	List<PostCharacter> findAllByCharacterCode(Long characterCode);

}

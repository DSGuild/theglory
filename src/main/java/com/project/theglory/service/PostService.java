package com.project.theglory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.theglory.model.Post;
import com.project.theglory.model.PostGeneral;
import com.project.theglory.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	
	public Post readPost(Long postId) {
		Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			return post.get();
		}
		
		throw new EntityNotFoundException("Can't Find Any Posts.");
	}

	public void createPost(Post post) {
		postRepository.save(post);
	}

	public Post getPost(Long id) {
		return postRepository.findById(id).orElse(null);
		
	}

	public void updatePost(Post post) {
		postRepository.save(post);
	}
	
}

package com.project.theglory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.theglory.model.PollSelection;
import com.project.theglory.model.Post;
import com.project.theglory.model.PostGeneral;
import com.project.theglory.model.PostPoll;
import com.project.theglory.repository.PollSelectionRepository;
import com.project.theglory.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	
	private final PollSelectionRepository pollSelectionRepository;
	
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

	public void createPostSelection(PostPoll postPoll) {
		List<PollSelection> selections = postPoll.getPollSelection();
		pollSelectionRepository.saveAll(selections);
	}
	
	
	
}

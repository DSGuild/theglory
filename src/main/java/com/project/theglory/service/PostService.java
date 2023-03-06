package com.project.theglory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;
import com.project.theglory.domain.repository.PostRepository;
import com.project.theglory.domain.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	final private PostRepository postRepository;
	final private ReplyRepository replyRepository;

	public List<Post> getPosts() {
		return postRepository.findAll();
	}

	public Post getPost(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	public void createPost(Post post) {
		postRepository.save(post);
		
	}

	public List<Reply> getReplies(Long id) {
		return replyRepository.getRepliesByPostId(id);
	}
	
}

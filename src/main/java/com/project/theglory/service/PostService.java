package com.project.theglory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.theglory.domain.entity.Favorite;
import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;
import com.project.theglory.domain.entity.User;
import com.project.theglory.domain.repository.FavoriteRepository;
import com.project.theglory.domain.repository.PostRepository;
import com.project.theglory.domain.repository.ReplyRepository;
import com.project.theglory.domain.repository.UserRepository;
import com.project.theglory.dto.FavoriteRequestDto;
import com.project.theglory.dto.PostResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	final private PostRepository postRepository;
	final private ReplyRepository replyRepository;

	public List<PostResponseDto> getPosts() {
		List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDto postResponseDto = PostResponseDto.builder()
                    .entity(post)
                    .likedByUser(false)
                    .build();
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
	}
	
	public List<PostResponseDto> getPosts(Long userId) {
		List<Object[]> postResults = postRepository.findAllWithIsLikedByUser(userId);
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for (Object[] postResult : postResults) {
        	Post post = (Post) postResult[0];
            boolean isLiked = (boolean) postResult[1];
            PostResponseDto postResponseDto = PostResponseDto.builder()
                    .entity(post)
                    .likedByUser(isLiked)
                    .build();
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
	}

	public Post getPost(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	public void createPost(Post post) {
		postRepository.save(post);
		
	}
	
	//TODO : 포스트 좋아요 순으로 정렬해서 RESPONSE
	public Post getOrderByFavorite() {
		return postRepository.orderByFavorite();
	}

	public void createReply(Reply reply) {
		replyRepository.save(reply);
	}
}

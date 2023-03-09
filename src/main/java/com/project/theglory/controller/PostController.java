package com.project.theglory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.domain.entity.Favorite;
import com.project.theglory.domain.entity.Post;
import com.project.theglory.domain.entity.Reply;
import com.project.theglory.domain.entity.User;
import com.project.theglory.dto.PostRequestDto;
import com.project.theglory.dto.PostResponseDto;
import com.project.theglory.dto.ReplyResponseDto;
import com.project.theglory.service.FavoriteService;
import com.project.theglory.service.PostService;
import com.project.theglory.service.ReplyService;
import com.project.theglory.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/post")
@RequiredArgsConstructor
public class PostController {
	
	final private PostService postService;
	final private ReplyService replyService;
	final private FavoriteService favoriteService;

	/**
	 * 전체 포스트를 가져온다.
	 * param으로 userId가 있을 경우 좋아요 누른 포스트를 체크하여 반환한다.
	 * @name getPosts
	 * @author heony
	 * @since 2023. 3. 7. 오후 5:23:03
	 * @comment 
	 * @param requestMap
	 * @return
	 */
	@GetMapping("/all/{id}")
	public List<PostResponseDto> getPosts(@PathVariable Long id) {
		List<PostResponseDto> responses;
		responses = postService.getPosts(id);
		return responses;
	}
	
	@GetMapping("/all")
	public List<PostResponseDto> getPosts() {
		List<PostResponseDto> responses = postService.getPosts();
		return responses;
	}
	
	@GetMapping("/{id}")
	public PostResponseDto getPost(@PathVariable Long id) {
		Post post = postService.getPost(id);
		return PostResponseDto.builder().entity(post).build();
	}
	
	@PostMapping("")
	public void createPost(@RequestBody PostRequestDto postRequestDto) {
		Post post = postRequestDto.toEntity();
		postService.createPost(post);
	}
	
	// TODO: post관련 Update, Delete구문 작성해야 함.
	
	@GetMapping("/{id}/reply")
	public List<ReplyResponseDto> getReplies(@PathVariable Long id) {
		List<Reply> replies = replyService.getReplies(id);
		List<ReplyResponseDto> responses = new ArrayList<ReplyResponseDto>();
		for (Reply r : replies) {
			responses.add(ReplyResponseDto.builder().entity(r).build()); 
		}
		return responses;
	}
	
	@PostMapping("/{postId}/favorite/{userId}")
    public ResponseEntity<?> addFavorite(@PathVariable Long postId, @PathVariable Long userId) {
        try {
            Post post = Post.builder().postId(postId).build();
            User user = User.builder().userId(userId).build();
            Favorite favorite = favoriteService.addFavorite(post, user);
            return ResponseEntity.ok(favorite);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{postId}/favorite/{userId}")
    public ResponseEntity<?> removeFavorite(@PathVariable Long postId, @PathVariable Long userId) {
    	Post post = Post.builder().postId(postId).build();
        User user = User.builder().userId(userId).build();
        favoriteService.removeFavorite(post, user);
        return ResponseEntity.ok().build();
    }
	
}

package com.project.theglory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.theglory.dto.Like;
import com.project.theglory.dto.Post;
import com.project.theglory.dto.Reply;
import com.project.theglory.dto.User;
import com.project.theglory.dto.Vote;
import com.project.theglory.service.LikeService;
import com.project.theglory.service.PostService;
import com.project.theglory.service.ReplyService;
import com.project.theglory.service.UserService;
import com.project.theglory.service.VoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {
	private final UserService userService;
	private final LikeService likeService;
	private final PostService postService;
	private final ReplyService replyService;
	private final VoteService voteService;
	
	@GetMapping("/user")
	public List<User> user() {
		return userService.getUserList();
	}
	
	@GetMapping("/like")
	public List<Like> like() {
		return likeService.getLikeList();
	}
	
	@GetMapping("/post")
	public List<Post> post() {
		return postService.getPostList();
	}
	
	@GetMapping("/reply")
	public List<Reply> reply() {
		return replyService.getReplyList();
	}
	
	@GetMapping("/vote")
	public List<Vote> vote() {
		return voteService.getVoteList();
	}
}

package com.project.theglory.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="post_poll")
public class Postpoll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postpollId;
	
	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "reply_num")
	private Integer replyNum;
	
	@Column(name = "hotnow")
	private boolean hotnow;
	
	@Column(name = "total_poll")
	private Integer totalPoll;
	
	
	@OneToMany(mappedBy = "postpoll")
	private List<PollSelection> pollSelection;

}

package com.project.theglory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="vote")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long voteId;
	
	@Column(name = "voteNum")
	private int voteNum;
	
	@Column(name = "image_one")
	private String imageOne;
	
	@Column(name = "image_two")
	private String imageTwo;
	
	@Column(name = "image_three")
	private String imageThree;
	
	@Column(name = "image_four")
	private String imageFour;
	
	@Column(name = "text")
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@Column(name = "vote_one")
	private String voteOne;
	
	@Column(name = "vote_two")
	private String voteTwo;
	
	@Column(name = "vote_three")
	private String voteThree;
	
	@Column(name = "vote_four")
	private String voteFour;
}

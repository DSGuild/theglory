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
@Table(name="poll_selection")
public class PollSelection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pollSelectionId;
	
	@ManyToOne
	@JoinColumn(name = "post_poll")
	private PostPoll postPoll;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "poll_num")
	private Integer pollNum;
	

}

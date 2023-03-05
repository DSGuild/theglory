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
@Table(name="post_general")
public class PostGeneral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postGeneralId;
	
	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "reply_num")
	private Integer replyNum;

}

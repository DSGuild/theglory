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
@Table(name="post_character")
public class PostCharacter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postCharacterId;
	
	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;
	
	@Column(name = "character_tag")
	private Integer characterTag;

}

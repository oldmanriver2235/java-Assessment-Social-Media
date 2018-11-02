package com.cooksys.ftd.SpringSocialMediaAssessment.Dto;

import java.sql.Timestamp;

public class TweetResponseDto {

	private String id;

	private UserResponseDto author;

	private Timestamp posted;

	private String content;

	public TweetResponseDto() {
	}

	public TweetResponseDto(String id, UserResponseDto author, Timestamp posted, String content) {
		super();
		this.id = id;
		this.author = author;
		this.posted = posted;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserResponseDto getAuthor() {
		return author;
	}

	public void setAuthor(UserResponseDto author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

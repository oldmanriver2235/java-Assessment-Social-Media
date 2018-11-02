package com.cooksys.ftd.SpringSocialMediaAssessment.Dto;

import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.UserCredentials;

public class TweetRequestDto {

	private String content;

	private UserCredentials userCredentials;

	public TweetRequestDto() {

	}

	public TweetRequestDto(String content, UserCredentials userCredentials) {
		super();
		this.content = content;
		this.userCredentials = userCredentials;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

}

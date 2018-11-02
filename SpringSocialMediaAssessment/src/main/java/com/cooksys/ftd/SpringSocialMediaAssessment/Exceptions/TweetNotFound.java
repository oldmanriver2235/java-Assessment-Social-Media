package com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions;

public class TweetNotFound extends Exception {

	private String message;

	public TweetNotFound() {
		this.message = "Tweet not found";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

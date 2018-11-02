package com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions;

public class UserNotFound extends Exception {

	private String message;

	public UserNotFound() {
		this.message = "User not found";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

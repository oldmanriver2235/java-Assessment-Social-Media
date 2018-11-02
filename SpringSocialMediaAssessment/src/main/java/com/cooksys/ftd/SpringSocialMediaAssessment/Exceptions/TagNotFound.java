package com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions;

public class TagNotFound extends Exception {

	private String message;

	public TagNotFound() {
		this.message = "Tag not found";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

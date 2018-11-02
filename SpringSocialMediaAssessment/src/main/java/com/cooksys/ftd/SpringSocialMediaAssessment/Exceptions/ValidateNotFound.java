package com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions;

public class ValidateNotFound extends Exception {

	private String message;

	public ValidateNotFound() {
		this.message = "Validate not found";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

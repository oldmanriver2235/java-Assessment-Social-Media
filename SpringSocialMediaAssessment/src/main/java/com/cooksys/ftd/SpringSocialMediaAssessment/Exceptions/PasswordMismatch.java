package com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions;

public class PasswordMismatch extends Exception {

	private String message;

	public PasswordMismatch() {
		this.message = "Provided password does not match";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;

	}

}

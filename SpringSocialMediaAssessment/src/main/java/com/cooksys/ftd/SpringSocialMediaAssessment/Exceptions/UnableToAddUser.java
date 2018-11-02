package com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions;

public class UnableToAddUser extends Exception {

	private String message;

	public UnableToAddUser() {
		this.message = "Unable to add user";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
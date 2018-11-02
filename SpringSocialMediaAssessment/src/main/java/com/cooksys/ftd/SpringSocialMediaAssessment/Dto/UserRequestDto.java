package com.cooksys.ftd.SpringSocialMediaAssessment.Dto;

import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.Profile;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.UserCredentials;

public class UserRequestDto {

	private UserCredentials userCredentials;

	private Profile profile;

	public UserRequestDto() {
	}

	public UserRequestDto(UserCredentials userCredentials, Profile profile) {
		super();
		this.userCredentials = userCredentials;
		this.profile = profile;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}

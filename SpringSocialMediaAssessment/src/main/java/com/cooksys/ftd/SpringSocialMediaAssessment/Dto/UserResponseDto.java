package com.cooksys.ftd.SpringSocialMediaAssessment.Dto;

import java.security.Timestamp;

import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.Profile;

public class UserResponseDto {

	private String username;

	private Profile profile;

	private Timestamp joined;

	public UserResponseDto() {
	}

	public UserResponseDto(String username, Profile profile, Timestamp joined) {
		super();
		this.username = username;
		this.profile = profile;
		this.joined = joined;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

}

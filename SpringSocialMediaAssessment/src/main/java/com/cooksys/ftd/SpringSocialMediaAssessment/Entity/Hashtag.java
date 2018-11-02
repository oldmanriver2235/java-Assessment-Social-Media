package com.cooksys.ftd.SpringSocialMediaAssessment.Entity;

import java.security.Timestamp;

import javax.persistence.Embeddable;

@Embeddable
public class Hashtag {

	private String label;

	private Timestamp firstUsed;

	private Timestamp lastUsed;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Timestamp getFirstUsed() {
		return firstUsed;
	}

	public void setFirstUsed(Timestamp firstUsed) {
		this.firstUsed = firstUsed;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

}

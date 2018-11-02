package com.cooksys.ftd.SpringSocialMediaAssessment.Entity;

import java.util.List;

public class Context {

	private Tweet target;

	private List<Tweet> before;

	private List<Tweet> after;

	public Tweet getTarget() {
		return target;
	}

	public void setTarget(Tweet target) {
		this.target = target;
	}

	public List<Tweet> getBefore() {
		return before;
	}

	public void setBefore(List<Tweet> before) {
		this.before = before;
	}

	public List<Tweet> getAfter() {
		return after;
	}

	public void setAfter(List<Tweet> after) {
		this.after = after;
	}

}

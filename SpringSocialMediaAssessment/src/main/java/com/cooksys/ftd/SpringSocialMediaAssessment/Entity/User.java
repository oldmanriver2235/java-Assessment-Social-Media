package com.cooksys.ftd.SpringSocialMediaAssessment.Entity;

import java.security.Timestamp;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private boolean active = true;

	@NotNull
	private Timestamp joined;

	@Embedded
	private Profile profile;

	@Embedded
	private UserCredentials userCredentials;

	@OneToMany(mappedBy = "author")
	private Set<Tweet> tweets;

	@ManyToMany
	private Set<User> followers;

	@ManyToMany
	private Set<User> following;

	@ManyToMany
	private Set<Tweet> mentions;

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public Set<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Set<Tweet> tweets) {
		this.tweets = tweets;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}

	public Set<Tweet> getMentions() {
		return mentions;
	}

	public void setMentions(Set<Tweet> mentions) {
		this.mentions = mentions;
	}

}

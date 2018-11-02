package com.cooksys.ftd.SpringSocialMediaAssessment.Entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@ManyToOne
	private User author;

	@NotNull
	private Timestamp posted;

	private String content;

	@ManyToMany
	private Set<Tweet> inReplyTo;

	@ManyToMany
	private Set<Tweet> repostOf;	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Tweet> getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(Set<Tweet> inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public Set<Tweet> getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Set<Tweet> repostOf) {
		this.repostOf = repostOf;
	}

}

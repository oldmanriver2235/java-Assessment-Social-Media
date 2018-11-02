package com.cooksys.ftd.SpringSocialMediaAssessment.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.Hashtag;
import com.cooksys.ftd.SpringSocialMediaAssessment.Services.TagService;

@RestController
@RequestMapping("tags")
public class TagController {

	private TagService tagService;

	public TagController(TagService tagService) {
		super();
		this.tagService = tagService;
	}

	@GetMapping
	public Hashtag getAllHashtags() {
		return this.tagService.getAllhashtags();
	}

	@GetMapping("/{label}")
	public Hashtag getLabeledHashtags(@PathVariable String label) {
		return this.tagService.getLabeledHashtags(label);
	}
}

package com.cooksys.ftd.SpringSocialMediaAssessment.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.SpringSocialMediaAssessment.Services.TagService;
import com.cooksys.ftd.SpringSocialMediaAssessment.Services.UserService;

import aj.org.objectweb.asm.Label;

@RestController
@RequestMapping("validate")
public class ValidateController {

	private TagService tagService;
	private UserService userService;

	public ValidateController() {
	}

	@GetMapping("/tag/exists/{label}")
	public boolean labelExists(@PathVariable Label label) {
		return this.tagService.labelExists(label);
	}
}
//	@GetMapping("/username/exists/@[username}")
//	public boolean usernameExists(@PathVariable String username) {
//		return this.userService.usernameExists(username);
//	}
//
//	@GetMapping("/username/available/@{username}")
//	public boolean usernameAvailable(@PathVariable String username) {
//		return this.userService.usernameExists(username);
//	}
//
//}

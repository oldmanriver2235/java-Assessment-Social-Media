package com.cooksys.ftd.SpringSocialMediaAssessment.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.TagNotFound;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.TweetNotFound;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.UserNotFound;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.ValidateNotFound;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(TagNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseMessage tagNotFound(TagNotFound e) {
		return new ResponseMessage(e.getMessage());
	}

	@ExceptionHandler(TweetNotFound.class)
	public ResponseMessage tweetNotFound(TweetNotFound e) {
		return new ResponseMessage(e.getMessage());
	}

	@ExceptionHandler(UserNotFound.class)
	public ResponseMessage userNotFound(UserNotFound e) {
		return new ResponseMessage(e.getMessage());
	}

	@ExceptionHandler(ValidateNotFound.class)
	public ResponseMessage validateNotFound(ValidateNotFound e) {
		return new ResponseMessage(e.getMessage());
	}
}

package com.cooksys.ftd.SpringSocialMediaAssessment.Controllers;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.SpringSocialMediaAssessment.Dto.TweetResponseDto;
import com.cooksys.ftd.SpringSocialMediaAssessment.Dto.UserRequestDto;
import com.cooksys.ftd.SpringSocialMediaAssessment.Dto.UserResponseDto;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.User;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.UserCredentials;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.PasswordMismatch;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.UnableToAddUser;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.UserNotFound;
import com.cooksys.ftd.SpringSocialMediaAssessment.Mapper.TweetResponseMapper;
import com.cooksys.ftd.SpringSocialMediaAssessment.Mapper.UserRequestMapper;
import com.cooksys.ftd.SpringSocialMediaAssessment.Mapper.UserResponseMapper;
import com.cooksys.ftd.SpringSocialMediaAssessment.Services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private UserService userService;
	private UserRequestMapper userRequestMapper;
	private UserResponseMapper userResponseMapper;
	private TweetResponseMapper tweetResponseMapper;

	public UserController(UserService userService, UserRequestMapper userRequestMapper,
			UserResponseMapper userResponseMapper, TweetResponseMapper tweetResponseMapper) {
		super();
		this.userService = userService;
		this.userRequestMapper = userRequestMapper;
		this.userResponseMapper = userResponseMapper;
		this.tweetResponseMapper = tweetResponseMapper;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@PostMapping()
	public UserResponseDto addUsers(@RequestBody UserRequestDto userRequestDto) throws UnableToAddUser {
		return this.userResponseMapper.toDto(this.userService.addUsers(this.userRequestMapper.fromDto(userRequestDto)));
	}

	@GetMapping("/@{username}")
	public UserResponseDto getUser(@PathVariable String username) throws UserNotFound {
		return this.userResponseMapper.toDto(this.userService.getUser(username));
	}

	@PatchMapping("/@{username}")
	public UserResponseDto patchUsers(@PathVariable String username, @RequestBody UserRequestDto userRequestDto)
			throws UserNotFound, PasswordMismatch {
		User user = this.userRequestMapper.fromDto(userRequestDto);
		return this.userResponseMapper
				.toDto(this.userService.patchUsers(username, user.getUserCredentials(), user.getProfile()));
	}

	@DeleteMapping("/@{username")
	public UserResponseDto deleteUsers(@PathVariable String username, @RequestBody UserRequestDto userRequestDto)
			throws UserNotFound {
		return this.userResponseMapper
				.toDto(this.userService.deleteUsers(username, this.userRequestMapper.fromDto(userRequestDto)));
	}

	@PostMapping("/@{username}/follow")
	public void followUsers(@PathVariable String username, @RequestBody UserRequestDto userRequestDto)
			throws PasswordMismatch {
		this.userService.followUsers(username, this.userRequestMapper.fromDto(userRequestDto).getUserCredentials());
	}

	@PostMapping("/@{username}/unfollow")
	public void unfollowUsers(@PathVariable String username, @RequestBody UserRequestDto userRequestDto)
			throws PasswordMismatch {
		this.userService.unfollowUsers(username, this.userRequestMapper.fromDto(userRequestDto).getUserCredentials());
	}

	@GetMapping("/@{username}/tweets")
	public Set<TweetResponseDto> getTweets(@PathVariable String username, @RequestBody UserRequestDto userRequestDto)
			throws UserNotFound {
		return this.tweetResponseMapper
				.toDtos(this.userService.getTweets(username, this.userRequestMapper.fromDto(userRequestDto)));
	}

	@GetMapping("/@{username}/mentions")
	public Set<TweetResponseDto> getMentionedTweets(@PathVariable String username,
			@RequestBody UserRequestDto userRequestDto) throws UserNotFound {
		return this.tweetResponseMapper
				.toDtos(this.userService.getMentionedTweets(username, this.userRequestMapper.fromDto(userRequestDto)));
	}

	@GetMapping("/@{username}/followers")
	public Set<UserResponseDto> getUserFollowers(@PathVariable String username,
			@RequestBody UserRequestDto userRequestDto) throws UserNotFound {
		return this.userResponseMapper
				.toDtos(this.userService.getUserFollowers(username, this.userRequestMapper.fromDto(userRequestDto)));
	}

	@GetMapping("/@{username}/following")
	public Set<UserResponseDto> getUserFollowed(@PathVariable String username,
			@RequestBody UserRequestDto userRequestDto) throws UserNotFound {
		return this.userResponseMapper
				.toDtos(this.userService.getUserFollowed(username, this.userRequestMapper.fromDto(userRequestDto)));
	}
}

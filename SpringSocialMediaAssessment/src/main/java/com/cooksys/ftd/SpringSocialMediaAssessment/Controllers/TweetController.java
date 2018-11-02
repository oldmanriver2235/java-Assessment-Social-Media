package com.cooksys.ftd.SpringSocialMediaAssessment.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.SpringSocialMediaAssessment.Services.TweetService;

@RestController
@RequestMapping("tweets")
public class TweetController {

	private TweetService tweetService;

	public TweetController(TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}

//	@GetMapping
//	public List<TweetResponseDto> getAllTweets() {
//		return this.tweetService.getAllTweets();
//	}
//
//	@PostMapping
//	public TweetResponseDto postTweet() {
//		return this.tweetResponseMapper.toDto(this.userService.postTweet(this.tweetRequestMapper.fromDto(tweetRequestDto)));
//		
//	}
//
//	@GetMapping("/{id}")
//	public TweetResponseDto getTweet(@PathVariable String id) {
//		return this.tweetResponseMapper.toDto(this.tweetService.getTweet(id));
//	}
//
//	@DeleteMapping("/{id}")
//	public TweetResponseDto deleteTweet(@PathVariable String id, @RequestBody TweetRequestDto, tweetRequestDto) {
//return this.tweetResp
//	}
//
//	@PostMapping("/{id}/like")
//	public TweetResponseDto likeTweet(@PathVariable String id) {
//		return this.tweetService.likeTweet(id);
//	}
//
//	@PostMapping("/{id}/reply")
//	public TweetResponseDto replyTweet(@PathVariable String id) {
//		return this.tweetService.replyTweet(id);
//	}
//
//	@PostMapping("/{id}/repost")
//	public TweetResponseDto repostTweet(@PathVariable String id) {
//		return this.tweetService.repostTweet(id);
//	}
//
//	@GetMapping("/{id}/tags")
//	public TweetResponseDto getTweetTags(@PathVariable String id) {
//		return this.tweetService.getTweetTags(id);
//	}
//
//	@GetMapping("/{id}/likes")
//	public TweetResponseDto getLikers(@PathVariable String id) {
//		return this.tweetService.getLikers(id);
//	}
//
//	@GetMapping("/{id}/context")
//	public TweetResponseDto getTweetContext(@PathVariable String id) {
//		return this.tweetService.getTweetContext(id);
//	}
//
//	@GetMapping("/{id}/replies")
//	public TweetResponseDto getTweetReplies(@PathVariable String id) {
//		return this.tweetService.getTweetReplies(id);
//	}
//	
//	@GetMapping("/{id}/repost")
//	public TweetResponseDto getTweetReposts(@PathVariable String id) {
//		return this.tweetService.getTweetReposts(id);
//	}
//
//	@GetMapping("/{id}/mentions")
//	public TweetResponseDto getTweetMentions(@PathVariable String id) {
//		return this.tweetService.getTweetmentions(id);
//    }
//	
}















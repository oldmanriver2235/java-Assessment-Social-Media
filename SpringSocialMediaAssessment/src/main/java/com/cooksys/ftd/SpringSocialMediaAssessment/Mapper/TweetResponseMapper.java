package com.cooksys.ftd.SpringSocialMediaAssessment.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.cooksys.ftd.SpringSocialMediaAssessment.Dto.TweetResponseDto;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.Tweet;

@Mapper(componentModel = "spring")
public interface TweetResponseMapper {

	TweetResponseDto toDto(Tweet tweet);

	Set<TweetResponseDto> toDtos(Set<Tweet> entities);
}

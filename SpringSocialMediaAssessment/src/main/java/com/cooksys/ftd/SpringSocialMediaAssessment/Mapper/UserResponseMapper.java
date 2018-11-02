package com.cooksys.ftd.SpringSocialMediaAssessment.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.ftd.SpringSocialMediaAssessment.Dto.UserResponseDto;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.User;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

	@Mapping(source = "userCredentials.username", target = "username")
	UserResponseDto toDto (User user);

	default User fromDto (UserResponseDto userResponseDto) {
		User user = new User();
		user.getUserCredentials().setUsername(userResponseDto.getUsername());
		user.setProfile(userResponseDto.getProfile());
		user.setJoined(userResponseDto.getJoined());
		return user;
	}

	Set<UserResponseDto> toDtos (Set<User> entities);
	
	


}

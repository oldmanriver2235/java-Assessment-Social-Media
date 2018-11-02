package com.cooksys.ftd.SpringSocialMediaAssessment.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.ftd.SpringSocialMediaAssessment.Dto.UserRequestDto;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.User;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

	UserRequestDto toDto(User Entity);
	
	User fromDto (UserRequestDto dto);

	List<UserRequestDto> toDtos(List<User> entities);

}
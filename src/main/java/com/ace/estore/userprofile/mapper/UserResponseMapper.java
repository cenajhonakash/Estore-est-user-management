package com.ace.estore.userprofile.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ace.estore.userprofile.entity.UserProfile;
import com.ace.estore.userprofile.response.dto.UserResponseDto;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
	UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

	UserResponseDto entityToDto(UserProfile entity);
}

package com.ace.estore.userprofile.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ace.estore.userprofile.entity.UserProfile;
import com.ace.estore.userprofile.request.dto.UserRequestDto;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

	UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

//	UserRequestDto entityToDto(UserProfile entity);

	UserProfile dtoToEntity(UserRequestDto dto);
}

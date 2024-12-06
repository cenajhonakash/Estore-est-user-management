package com.ace.estore.userprofile.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ace.estore.userprofile.constants.ApplicationConstants;
import com.ace.estore.userprofile.entity.UserProfile;
import com.ace.estore.userprofile.entity.UserRole;
import com.ace.estore.userprofile.mapper.UserProfileMapper;
import com.ace.estore.userprofile.mapper.UserResponseMapper;
import com.ace.estore.userprofile.repository.UserProfileRepository;
import com.ace.estore.userprofile.request.dto.CredentialsDto;
import com.ace.estore.userprofile.request.dto.UserRequestDto;
import com.ace.estore.userprofile.response.ApiResponse;
import com.ace.estore.userprofile.response.FailureResponse;
import com.ace.estore.userprofile.service.UserProfileService;

public class UserServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;
	@Autowired
	private UserProfileMapper userReqMapper;
	@Autowired
	private UserResponseMapper userResponseMapper;

	@Override
	public ApiResponse getUserByUsername(String userName) {
		return null;
	}

	@Override
	public ApiResponse getUserByCredentials(CredentialsDto credentials) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse createNewUser(UserRequestDto userDto, MultipartFile image) {
		validateMandatoryFields(userDto);
		UserProfile user = userReqMapper.dtoToEntity(userDto);
		user.setRoles(ApplicationConstants.DEFAULT_ROLES.stream().map(role -> UserRole.builder().role(role).build())
				.collect(Collectors.toSet()));
		UserProfile newUser = userProfileRepository.saveAndFlush(user);
		return ApiResponse.builder().data(Arrays.asList(userResponseMapper.entityToDto(newUser))).build();
	}

	@Override
	public ApiResponse updateUser(UserRequestDto userDto, MultipartFile image) {
		// TODO Auto-generated method stub
		return null;
	}

	private ApiResponse validateMandatoryFields(UserRequestDto userDto) {
		List<String> warnings = new ArrayList<>();
//		if (!StringUtils.hasLength(userDto.userId()))
//			warnings.add("User Id is missing");
		if (!StringUtils.hasLength(userDto.firstName()))
			warnings.add("First name is missing");
		if (!StringUtils.hasLength(userDto.password()))
			warnings.add("Password is missing");
		if (!StringUtils.hasLength(userDto.gender()))
			warnings.add("Gender is missing");
		if (!StringUtils.hasLength(userDto.email()))
			warnings.add("Email is missing");
		return ApiResponse.builder().failure(FailureResponse.builder().warnings(warnings).build()).build();
	}
}

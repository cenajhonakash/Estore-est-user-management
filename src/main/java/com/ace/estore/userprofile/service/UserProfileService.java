package com.ace.estore.userprofile.service;

import org.springframework.web.multipart.MultipartFile;

import com.ace.estore.userprofile.request.dto.CredentialsDto;
import com.ace.estore.userprofile.request.dto.UserRequestDto;
import com.ace.estore.userprofile.response.ApiResponse;

public interface UserProfileService {

	public ApiResponse getUserByUsername(String userName);

	public ApiResponse getUserByCredentials(CredentialsDto credentials);

	public ApiResponse createNewUser(UserRequestDto userDto, MultipartFile image);

	public ApiResponse updateUser(UserRequestDto userDto, MultipartFile image);
}

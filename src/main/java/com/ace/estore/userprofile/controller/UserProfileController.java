package com.ace.estore.userprofile.controller;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ace.estore.userprofile.exception.ResourceAlreadyExistsException;
import com.ace.estore.userprofile.exception.ResourceNotFoundException;
import com.ace.estore.userprofile.exception.ValidationException;
import com.ace.estore.userprofile.request.dto.CredentialsDto;
import com.ace.estore.userprofile.request.dto.UserRequestDto;
import com.ace.estore.userprofile.response.ApiResponse;
import com.ace.estore.userprofile.service.UserProfileService;

public class UserProfileController {

	@Autowired
	public UserProfileService profileService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse> createUser(@RequestBody(required = true) UserRequestDto userDto)
			throws ResourceAlreadyExistsException, ValidationException {
		return new ResponseEntity<>(profileService.createNewUser(userDto, null), HttpStatus.CREATED);
	}

	/*
	 * JWT protected endpoint
	 */
	@GetMapping("/{userName}")
	public ResponseEntity<ApiResponse> getUser(@PathVariable("userName") String userName)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(profileService.getUserByUsername(userName), HttpStatus.FOUND);
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<ApiResponse> getUserByCredentials(@RequestBody(required = true) CredentialsDto credentials)
			throws ResourceNotFoundException, InvalidCredentialsException, ValidationException {
		return new ResponseEntity<>(profileService.getUserByCredentials(credentials), HttpStatus.FOUND);
	}

	/*
	 * JWT protected endpoint
	 */
	@DeleteMapping("/{userID}")
	public void deleteUser(@PathVariable("userID") Long userID) {

	}

	/*
	 * JWT protected
	 */
	@PutMapping("/update/{userID}")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody UserRequestDto userDto,
			@PathVariable("userID") Long userID) throws ValidationException {
		return new ResponseEntity<>(profileService.updateUser(userDto, null), HttpStatus.OK);
	}
}

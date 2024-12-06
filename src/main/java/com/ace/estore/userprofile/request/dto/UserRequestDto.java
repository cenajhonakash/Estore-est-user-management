package com.ace.estore.userprofile.request.dto;

import lombok.Builder;

@Builder
public record UserRequestDto(Long userId, String firstName, String lastName, String email, String password,
		String gender, String about, String phone) {

}

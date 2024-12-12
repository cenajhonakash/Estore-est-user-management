package com.ace.estore.userprofile.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UserRoleDetailsDto {
	private String firstName;
	private String lastName;
	private String username;
	private String contact;
	private String email;
	private String role;
}

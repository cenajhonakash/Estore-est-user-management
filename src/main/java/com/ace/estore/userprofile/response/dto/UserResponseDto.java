package com.ace.estore.userprofile.response.dto;

import com.ace.estore.userprofile.response.BaseResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class UserResponseDto extends BaseResponseDto {

	private String username;
	private String email;
	private String firstName;
	private String lastName;
	// private Set<String> roles;
	private String gender;
	private String createdDate;
	private String updatedDate;
	private Boolean enabled;
	private String phone;
	private String imageURL;
	private String about;
}

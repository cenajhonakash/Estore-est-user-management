package com.ace.estore.userprofile.response.dto;

import java.time.LocalDateTime;

import com.ace.estore.userprofile.constants.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserDetailsDto {
	private String firstName;
	private String lastName;
	private String username;
	private String contact;
	private String email;
	private String role;
	private String gender;
	private Boolean active;
	private String image;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ApplicationConstants.DT_PATTERN)
	private LocalDateTime memberSince;
}

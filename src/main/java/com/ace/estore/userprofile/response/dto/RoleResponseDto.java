package com.ace.estore.userprofile.response.dto;

import java.util.List;

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
public class RoleResponseDto extends BaseResponseDto {
	private List<UserDetailsDto> users;
}

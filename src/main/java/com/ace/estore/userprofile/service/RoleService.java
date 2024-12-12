package com.ace.estore.userprofile.service;

import com.ace.estore.userprofile.exception.ResourceNotFoundException;
import com.ace.estore.userprofile.exception.ValidationException;
import com.ace.estore.userprofile.response.dto.RoleResponseDto;

public interface RoleService {

	RoleResponseDto getUsersByRole(String roleCode, String roleName, String roleId)
			throws ResourceNotFoundException, ValidationException;

}

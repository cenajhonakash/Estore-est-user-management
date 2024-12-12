package com.ace.estore.userprofile.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.estore.userprofile.exception.ValidationException;
import com.ace.estore.userprofile.repository.RoleRepository;
import com.ace.estore.userprofile.response.dto.RoleResponseDto;
import com.ace.estore.userprofile.response.dto.RoleResponseDto.RoleResponseDtoBuilder;
import com.ace.estore.userprofile.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public RoleResponseDto getUsersByRole(String roleCode, String roleName, String roleId) throws ValidationException {
		if (Objects.isNull(roleId) && Objects.isNull(roleCode) && Objects.isNull(roleName))
			throw new ValidationException("Invalid Request!!");
		RoleResponseDtoBuilder roleBuilder = RoleResponseDto.builder();
		if (Objects.nonNull(roleName) && Objects.isNull(roleId) && Objects.isNull(roleCode))
			roleBuilder.users(roleRepo.fetchUsersForRoleName(roleName));
		if (Objects.nonNull(roleId) && Objects.isNull(roleName) && Objects.isNull(roleCode))
			roleBuilder.users(roleRepo.fetchUsersForRoleId(roleId));
		if (Objects.nonNull(roleCode) && Objects.isNull(roleId) && Objects.isNull(roleName))
			roleBuilder.users(roleRepo.fetchUsersForRoleCode(roleCode));
		return roleBuilder.build();
	}

}

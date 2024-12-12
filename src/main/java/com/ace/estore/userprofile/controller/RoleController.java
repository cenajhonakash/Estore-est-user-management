package com.ace.estore.userprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ace.estore.userprofile.exception.ResourceNotFoundException;
import com.ace.estore.userprofile.exception.ValidationException;
import com.ace.estore.userprofile.response.dto.RoleResponseDto;
import com.ace.estore.userprofile.service.RoleService;

@RestController
@RequestMapping("/v1/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<RoleResponseDto> getAllUsersForRole(
			@RequestParam(name = "roleCode", required = false) String roleCode,
			@RequestParam(name = "roleName", required = false) String roleName,
			@RequestParam(name = "roleId", required = false) String roleId)
			throws ResourceNotFoundException, ValidationException {
		return new ResponseEntity<RoleResponseDto>(roleService.getUsersByRole(roleCode, roleName, roleId),
				HttpStatus.OK);
	}
}

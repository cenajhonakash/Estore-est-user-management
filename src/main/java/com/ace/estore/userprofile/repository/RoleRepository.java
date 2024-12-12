package com.ace.estore.userprofile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ace.estore.userprofile.constants.QueryConstant;
import com.ace.estore.userprofile.entity.Role;
import com.ace.estore.userprofile.response.dto.UserRoleDetailsDto;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query(value = QueryConstant.FETCH_USER_AND_ROLE_DETAILS_BY_ROLE_NAME)
	List<UserRoleDetailsDto> fetchUsersForRoleName(String roleName);

	@Query(value = QueryConstant.FETCH_USER_AND_ROLE_DETAILS_BY_ROLE_CODE)
	List<UserRoleDetailsDto> fetchUsersForRoleCode(String roleCode);

	@Query(value = QueryConstant.FETCH_USER_AND_ROLE_DETAILS_BY_ROLE_ID)
	List<UserRoleDetailsDto> fetchUsersForRoleId(String roleId);
}
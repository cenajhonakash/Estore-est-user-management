package com.ace.estore.userprofile.constants;

public class QueryConstant {
	private static final String FETCH_USER_AND_ROLE_DETAILS = """
			select new com.ace.estore.userprofile.response.dto.UserDetailsDto(us.firstName as firstName,  us.lastName as lastName,  us.username as username,
			us.phone as contact,  us.email as email, rol.roleName as role, us.gender as gender, us.enabled as active, us.imageURL as image, us.createdDate as memberSince)
			from Role rol join rol.roles ur join ur.user us where
			""";
	public static final String FETCH_USER_AND_ROLE_DETAILS_BY_ROLE_CODE = FETCH_USER_AND_ROLE_DETAILS
			+ " rol.roleCode = ?1";
	public static final String FETCH_USER_AND_ROLE_DETAILS_BY_ROLE_NAME = FETCH_USER_AND_ROLE_DETAILS
			+ " rol.roleName = ?1";
	public static final String FETCH_USER_AND_ROLE_DETAILS_BY_ROLE_ID = FETCH_USER_AND_ROLE_DETAILS
			+ " rol.roleId = ?1";

}

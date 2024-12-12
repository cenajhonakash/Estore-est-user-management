package com.ace.estore.userprofile.constants;

public enum RoleEnum {

	CUSTOMER(1L, "CUSTOMER", "CUS"), STORE_ASSOCIATE(2L, "STORE ASSOCIATE", "SAS"),
	STORE_ADMIN(3L, "STORE ADMIN", "SAD"), STORE_MANAGER(4L, "STORE MANAGER", "SMA");

	private final Long roleId;
	private final String roleCode;
	private final String roleName;

	RoleEnum(Long roleId, String roleKey, String roleName) {
		this.roleCode = roleKey;
		this.roleName = roleName;
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

}

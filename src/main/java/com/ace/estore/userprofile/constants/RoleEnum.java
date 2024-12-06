package com.ace.estore.userprofile.constants;

public enum RoleEnum {

	CUSTOMER("CUSTOMER", "CUS"), STORE_ASSOCIATE("STORE ASSOCIATE", "SAS"), STORE_ADMIN("STORE ADMIN", "SAD"),
	STORE_MANAGER("STORE MANAGER", "SMA");

	private final String role;
	private final String roleKey;

	RoleEnum(String key, String value) {
		this.role = key;
		this.roleKey = value;
	}

	public String getKey() {
		return role;
	}

	public String getValue() {
		return roleKey;
	}

}

package com.ace.estore.userprofile.constants;

import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ApplicationConstants {
	public static final DateTimeFormatter DT_FORMATTER_MS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	public static final Set<String> DEFAULT_ROLES = Set.of(RoleEnum.CUSTOMER.getValue());
}

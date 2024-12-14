package com.ace.estore.userprofile.constants;

import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ApplicationConstants {
	public static final String DT_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final DateTimeFormatter DT_FORMATTER_MS = DateTimeFormatter.ofPattern(DT_PATTERN);
	public static final Set<Long> DEFAULT_ROLES = Set.of(RoleEnum.CUSTOMER.getRoleId());
}

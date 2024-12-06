package com.ace.estore.userprofile.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ace.estore.userprofile.constants.ApplicationConstants;

@Component
public class AppUtils {

	public LocalDateTime convertStringToLocalDateTimeMs(String date) {
		return LocalDateTime.parse(date, ApplicationConstants.DT_FORMATTER_MS);
	}

}

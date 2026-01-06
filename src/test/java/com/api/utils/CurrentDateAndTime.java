package com.api.utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class CurrentDateAndTime {
	
public static	String dueDate = DateTimeFormatter
	        .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	        .withZone(ZoneOffset.UTC)
	        .format(Instant.now());

}

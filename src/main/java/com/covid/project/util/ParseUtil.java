package com.covid.project.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseUtil {

	public static Integer parseInt(String str) {
		Integer num = null;
		if(str.contains(".")) {
			num = Integer.parseInt(str.replace(".0", ""));
		} else {
			num = Integer.parseInt(str);
		}
		return num;
	}
	
	public static LocalDate parseLocalDate(String str, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(str, formatter);
	}
	
	public static String parseLocalDateToString(LocalDate date, String format) {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern(format);
		String text = date.format(formatters);
		return text;
	}
	
	public static LocalDate parseAndChangeFormatLocalDate(String str, String orig, String newFormat) {
		LocalDate original = parseLocalDate(str, orig );
		String stringifiedLocalDate = parseLocalDateToString(original, newFormat);
		return parseLocalDate(stringifiedLocalDate, newFormat);
	}
}

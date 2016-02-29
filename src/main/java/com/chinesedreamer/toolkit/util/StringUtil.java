package com.chinesedreamer.toolkit.util;

public class StringUtil {
	public static String upperCaseFirstCharacter(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}

package com.thinkgem.jeesite.common.utils;

public class EncodingUtil {
	public static final String DEFAULT_ENCODING_STRING = "utf-8";
	public static String getEncoding(String encoding){
		if(encoding == null || "".equals(encoding)){
			return DEFAULT_ENCODING_STRING;
		}
		return encoding;
	}
}

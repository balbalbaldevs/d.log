package com.dlog.diary.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Tools {
	public static String encode(String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
}

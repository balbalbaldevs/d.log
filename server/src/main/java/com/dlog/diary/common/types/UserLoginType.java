package com.dlog.diary.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserLoginType {
	KAKAOTALK("카카오톡"),
	FACEBOOK("페이스북"),
	EMAIL("이메일");
	
	private final String description;

	UserLoginType(String description) {
		this.description = description;
	}
	
	@JsonValue
	public String getDescription() {
		return description;
	}
}

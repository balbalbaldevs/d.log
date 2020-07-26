package com.dlog.diary.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserSexType {
	MALE("남자"),
	FEMALE("여자");
	
	private final String description;

	UserSexType(String description) {
		this.description = description;
	}
	
	@JsonValue
	public String getDescription() {
		return description;
	}
}

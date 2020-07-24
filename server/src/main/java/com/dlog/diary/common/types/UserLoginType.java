package com.dlog.diary.common.types;

public enum UserLoginType {
	KAKAOTALK("카카오톡"),
	FACEBOOK("페이스북"),
	EMAIL("이메일");
	
	private final String description;

	UserLoginType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

package com.dlog.diary.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GoalStateType {
	TO_DO("커밍쑨!"),
	IN_PROGRESS("진행중"),
	SUCCESS("성공!"),
	FAIL("실패ㅠ"),
	PAUSED("중지");
	
	private final String description;

	GoalStateType(String description) {
		this.description = description;
	}
	
	@JsonValue
	public String getDescription() {
		return description;
	}
}

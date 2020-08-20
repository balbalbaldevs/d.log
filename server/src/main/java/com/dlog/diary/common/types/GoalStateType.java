package com.dlog.diary.common.types;

public enum GoalStateType implements DlogEnum {
	TO_DO("커밍쑨!"),
	IN_PROGRESS("진행중"),
	SUCCESS("성공!"),
	FAIL("실패ㅠ"),
	PAUSED("중지");
	
	private final String description;

	GoalStateType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

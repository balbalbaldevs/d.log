package com.dlog.diary.common.types;

public enum MealType implements DlogEnum {
	BREAKFAST("아침"), LUNCH("점심"), DINNER("저녁"), SNACK("간식");

	private final String description;

	MealType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

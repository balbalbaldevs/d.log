package com.dlog.diary.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UnitType {
	KG("kg"),
	CM("cm");
	
	private final String description;

	UnitType(String description) {
		this.description = description;
	}
	
	@JsonValue
	public String getDescription() {
		return description;
	}
}

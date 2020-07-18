package com.dlog.diary.common.types;

public enum UnitType {
	KG("kg"),
	CM("cm");
	
	private final String description;

	UnitType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

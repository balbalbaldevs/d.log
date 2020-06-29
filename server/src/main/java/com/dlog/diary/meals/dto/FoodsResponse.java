package com.dlog.diary.meals.dto;

import lombok.Data;

@Data
public class FoodsResponse {
	private String foodName;
	private int calorie;
	private int carbs;
	private int protein;
	private int fat;
	private int amount;
	private String amountUnit;
}

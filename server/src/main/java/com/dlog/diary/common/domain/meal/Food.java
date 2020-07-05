package com.dlog.diary.common.domain.meal;

import lombok.Data;

@Data
public class Food {
	private int foodId;
	private int mealDetailId;
	private String foodName;
	private String calorie;
	private String carbs;
	private String protein;
	private String fat;
	private String amount;
	private String amountUnit;
}

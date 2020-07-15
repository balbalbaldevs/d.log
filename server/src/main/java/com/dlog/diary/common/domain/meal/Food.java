package com.dlog.diary.common.domain.meal;

import lombok.Data;

@Data
public class Food {
	private int foodSequence;
	private int mealDiarySequence;
	private String foodName;
	private int calorie;
	private String carbs;
	private String protein;
	private String fat;
	private String amount;
	private String amountUnit;
}

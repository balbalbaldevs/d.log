package com.dlog.diary.common.domain.food;

import lombok.Data;

@Data
public class FoodNutrition {
	private String foodName;
	private String servingSize;
	private String calorie; // NUTR_CONT1
	private String carbs; // NUTR_CONT2
	private String protein; // NUTR_CONT3
	private String fat; // NUTR_CONT4
	private String sugar; // NUTR_CONT5
	private String sodium; // NUTR_CONT6
	private String cholesterol; // NUTR_CONT7
	private String fattyAcids; // NUTR_CONT8
	private String transFattyAcids; // NUTR_CONT9
}

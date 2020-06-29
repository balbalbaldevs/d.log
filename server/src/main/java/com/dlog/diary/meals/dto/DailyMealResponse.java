package com.dlog.diary.meals.dto;

import java.util.List;

import lombok.Data;

@Data
public class DailyMealResponse {
	private String date;
	private int totalCalories;
	private List<MealResponse> meals;

}

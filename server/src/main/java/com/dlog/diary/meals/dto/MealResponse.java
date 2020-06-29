package com.dlog.diary.meals.dto;

import java.util.List;

import lombok.Data;

@Data
public class MealResponse {
	private String mealType;
	private int mealCalories;
	private String mealPhotoPath;
	private List<FoodsResponse> foods;
}

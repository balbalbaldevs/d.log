package com.dlog.diary.meal.dto;

import java.util.ArrayList;
import java.util.List;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.common.types.MealType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class EditDailyMealsRequest {
	// TODO Validation 추가

	@ApiModelProperty(required = true, value = "식단 시퀀스", example = "456")
	private int mealDiarySequence;
	@ApiModelProperty(required = true, value = "식사 사진 경로", example = "'/20200701/photo/breakfast.png'")
	private String photoPath;
	@ApiModelProperty(required = true, value = "식사 종류 : BREAKFAST, LUNCH, DINNER, SNACK", example = "'BREAKFAST'")
	private MealType mealType;
	@ApiModelProperty(required = true, value = "섭취한 음식 목록")
	private List<EditFoodRequest> foods;

	public DailyMeals getDailyMeals(String uniqueId, String diaryDay) {
		DailyMeals dailyMeals = new DailyMeals();
		dailyMeals.setMealDiarySequence(mealDiarySequence);
		dailyMeals.setMealType(mealType);
		dailyMeals.setPhotoPath(photoPath);
		dailyMeals.setUniqueId(uniqueId);
		dailyMeals.setDiaryDayForm(diaryDay);

		int mealTotalCalorie = 0;
		List<Food> newFoods = new ArrayList<>();
		for (EditFoodRequest editFood : foods) {
			Food food = new Food();
			food.setFoodSequence(editFood.getFoodSequence());
			food.setMealDiarySequence(mealDiarySequence);
			food.setFoodName(editFood.getFoodName());
			food.setCalorie(editFood.getCalorie());
			food.setCarbs(editFood.getCarbs());
			food.setFat(editFood.getFat());
			food.setProtein(editFood.getProtein());
			food.setAmount(editFood.getAmount());
			food.setAmountUnit(editFood.getAmountUnit());
			newFoods.add(food);

			mealTotalCalorie += editFood.getCalorie();
		}

		dailyMeals.setFoods(newFoods);
		dailyMeals.setMealTotalCalorie(mealTotalCalorie);
		return dailyMeals;
	}
}

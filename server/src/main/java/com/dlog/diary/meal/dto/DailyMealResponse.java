package com.dlog.diary.meal.dto;

import java.util.ArrayList;
import java.util.List;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DailyMealResponse {
	@ApiModelProperty(required = true, value = "다이어리 시퀀스", example = "1")
	private int diarySequence;
	@ApiModelProperty(required = true, value = "식단 일자", example = "'20200701'")
	private String diaryDay;
	@ApiModelProperty(required = true, value = "최종 수정일자", example = "'20200701'")
	private String lastUpdateDate;
	@ApiModelProperty(required = true, value = "총 섭취 칼로리", example = "1200")
	private int totalCalories;
	@ApiModelProperty(required = true, value = "식단 목록")
	private List<MealDiaryResponse> mealDiaries = new ArrayList<>();

	public void setDailyMeals(List<DailyMeals> dailyMeals) {
		if (dailyMeals.size() > 0) {
			this.diarySequence = dailyMeals.get(0).getDiarySequence();
			this.diaryDay = dailyMeals.get(0).getDiaryDayForm();
			this.lastUpdateDate = dailyMeals.get(0).getModifyDateForm();

			for (DailyMeals dailyMeal : dailyMeals) {
				this.totalCalories += dailyMeal.getMealTotalCalorie();

				MealDiaryResponse mealDiary = new MealDiaryResponse();
				mealDiary.setMealDiarySequence(dailyMeal.getMealDiarySequence());
				mealDiary.setMealCalories(dailyMeal.getMealTotalCalorie());
				mealDiary.setMealPhotoPath(dailyMeal.getPhotoPath());
				mealDiary.setMealType(dailyMeal.getMealType().toString());

				List<FoodResponse> foods = new ArrayList<>();
				for (Food food : dailyMeal.getFoods()) {
					FoodResponse foodResponse = new FoodResponse();
					foodResponse.setFoodSequence(food.getFoodSequence());
					foodResponse.setAmount(food.getAmount());
					foodResponse.setAmountUnit(food.getAmountUnit());
					foodResponse.setCalorie(food.getCalorie());
					foodResponse.setCarbs(food.getCarbs());
					foodResponse.setFat(food.getFat());
					foodResponse.setProtein(food.getProtein());
					foodResponse.setFoodName(food.getFoodName());
					foods.add(foodResponse);
				}

				mealDiary.setFoods(foods);
				this.mealDiaries.add(mealDiary);
			}
		}

	}

	public void setEmpty() {
		this.diarySequence = 0;
		this.diaryDay = "";
		this.lastUpdateDate = "";
		this.totalCalories = 0;
	}
}
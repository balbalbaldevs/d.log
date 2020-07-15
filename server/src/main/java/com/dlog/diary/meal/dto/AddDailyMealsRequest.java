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
public class AddDailyMealsRequest {
	@ApiModelProperty(required = true, value = "식사 사진 경로", example = "/20200701/photo/breakfast.png")
	private String photoPath;
	@ApiModelProperty(required = true, value = "식사 종류 : BREAKFAST, LUNCH, DINNER, SNACK", example = "BREAKFAST")
	private MealType mealType;
	@ApiModelProperty(required = true, value = "섭취한 음식 목록")
	private List<AddFoodRequest> foods;

	public DailyMeals getDailyMeals(String uniqueId, String diaryDay) {
		int mealTotalCalorie = 0;
		DailyMeals dailyMeals = new DailyMeals();
		dailyMeals.setUniqueId(uniqueId);
		dailyMeals.setDiaryDayForm(diaryDay);
		dailyMeals.setMealType(mealType);
		dailyMeals.setPhotoPath(photoPath);

		List<Food> newFoods = new ArrayList<>();
		for (AddFoodRequest addFoodRequest : foods) {
			Food food = new Food();
			food.setFoodSequence(addFoodRequest.getFoodSequence());
			food.setFoodName(addFoodRequest.getFoodName());
			food.setCalorie(addFoodRequest.getCalorie());
			food.setCarbs(addFoodRequest.getCarbs());
			food.setFat(addFoodRequest.getFat());
			food.setProtein(addFoodRequest.getProtein());
			food.setAmount(addFoodRequest.getAmount());
			food.setAmountUnit(addFoodRequest.getAmountUnit());
			newFoods.add(food);

			mealTotalCalorie += addFoodRequest.getCalorie();
		}

		dailyMeals.setFoods(newFoods);
		dailyMeals.setMealTotalCalorie(mealTotalCalorie);
		return dailyMeals;
	}
}

package com.dlog.diary.meal.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.meal.dto.AddDailyMealsRequest;
import com.dlog.diary.meal.dto.AddFoodRequest;
import com.dlog.diary.meal.dto.DailyMealResponse;
import com.dlog.diary.meal.dto.EditDailyMealsRequest;
import com.dlog.diary.meal.dto.EditFoodRequest;
import com.dlog.diary.meal.dto.FoodResponse;
import com.dlog.diary.meal.dto.MealDiaryResponse;

@Mapper(componentModel = "spring")
public interface MealMappingService {

	@Mappings({ 
		@Mapping(target = "diarySequence", source = "mailyMeals.diarySequence"),
		@Mapping(target = "diaryDay", source = "mailyMeals.diaryDayForm"),
		@Mapping(target = "lastUpdateDate", source = "mailyMeals.modifyDate", dateFormat = "dd.MM.yyyy") 
	})
	DailyMealResponse test(DailyMeals mailyMeals);
	
    default DailyMealResponse dailyToResponse(List<DailyMeals> meals) {
    	if (meals == null) {
			return null;
		}

    	DailyMealResponse response = new DailyMealResponse();
    	response.setDiaryDay(meals.get(0).getDiaryDayForm());
    	response.setDiarySequence(meals.get(0).getDiarySequence());
    	response.setLastUpdateDate(meals.get(0).getModifyDateForm());
		response.setMealDiaries(mealsToResponse(meals));
		int totalCalories = 0;
		for (MealDiaryResponse dailyMeals : response.getMealDiaries()) {
			totalCalories += dailyMeals.getMealCalories();
		}
		response.setTotalCalories(totalCalories);
    	
        return response;
    }

	List<MealDiaryResponse> mealsToResponse(List<DailyMeals> meals);

	@Mappings({
		@Mapping(target = "mealCalories", source = "dailyMeals.mealTotalCalorie"),
		@Mapping(target = "mealPhotoPath", source = "dailyMeals.photoPath") 
	})
	MealDiaryResponse mealToResponse(DailyMeals dailyMeals);

	List<FoodResponse> foodsToResponse(List<Food> foods);

	FoodResponse foodToResponse(Food food);

	List<DailyMeals> requestToMeals(List<AddDailyMealsRequest> addDailyMealsRequests);

	default DailyMeals requestToMeal(AddDailyMealsRequest addDailyMealsRequest) {
		if (addDailyMealsRequest == null) {
			return null;
		}

		DailyMeals dailyMeals = new DailyMeals();
		dailyMeals.setMealType(addDailyMealsRequest.getMealType());
		dailyMeals.setPhotoPath(addDailyMealsRequest.getPhotoPath());
		dailyMeals.setFoods(requestToFoods(addDailyMealsRequest.getFoods()));
		int mealTotalCalorie = 0;
		for (Food food : dailyMeals.getFoods()) {
			mealTotalCalorie += food.getCalorie();
		}
		dailyMeals.setMealTotalCalorie(mealTotalCalorie);

		return dailyMeals;
	}

	List<Food> requestToFoods(List<AddFoodRequest> addFoodRequests);

	Food requestToFood(AddFoodRequest addFoodRequest);

	List<DailyMeals> requestToEditMeals(List<EditDailyMealsRequest> editDailyMealsRequests);

	default DailyMeals requestToEditMeal(EditDailyMealsRequest editDailyMealsRequest) {
		if (editDailyMealsRequest == null) {
			return null;
		}

		DailyMeals dailyMeals = new DailyMeals();
		dailyMeals.setMealDiarySequence(editDailyMealsRequest.getMealDiarySequence());
		dailyMeals.setMealType(editDailyMealsRequest.getMealType());
		dailyMeals.setPhotoPath(editDailyMealsRequest.getPhotoPath());
		dailyMeals.setFoods(requestToEditFoods(editDailyMealsRequest.getFoods()));
		int mealTotalCalorie = 0;
		for (Food food : dailyMeals.getFoods()) {
			mealTotalCalorie += food.getCalorie();
		}
		dailyMeals.setMealTotalCalorie(mealTotalCalorie);

		return dailyMeals;
	}

	List<Food> requestToEditFoods(List<EditFoodRequest> editFoodRequests);

	Food requestToEditFood(EditFoodRequest editFoodRequest);
}

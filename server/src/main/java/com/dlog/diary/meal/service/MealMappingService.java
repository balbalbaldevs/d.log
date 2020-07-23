package com.dlog.diary.meal.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.meal.dto.DailyMealResponse;
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
		@Mapping(target = "mealCalories", source = "meal.mealTotalCalorie"),
		@Mapping(target = "mealPhotoPath", source = "meal.photoPath"),
	})
    MealDiaryResponse mealToResponse(DailyMeals meal);

	List<FoodResponse> foodsToResponse(List<Food> foods);
	
	FoodResponse foodToResponse(Food food);

}

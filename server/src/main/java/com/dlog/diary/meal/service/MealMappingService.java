package com.dlog.diary.meal.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.meal.dto.DailyMealResponse;
import com.dlog.diary.meal.dto.FoodResponse;

@Mapper(componentModel = "spring")
public interface MealMappingService {

	@Mappings({ 
		@Mapping(target = "diarySequence", source = "mailyMeals.diarySequence"),
		@Mapping(target = "diaryDay", source = "mailyMeals.diaryDayForm"),
		@Mapping(target = "lastUpdateDate", source = "mailyMeals.modifyDate", dateFormat = "dd.MM.yyyy") 
	})
	DailyMealResponse test(DailyMeals mailyMeals);
	
	List<FoodResponse> foodsToResponse(List<Food> foods);
	
	FoodResponse foodToResponse(Food foods);
}

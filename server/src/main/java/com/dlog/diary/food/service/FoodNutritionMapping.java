package com.dlog.diary.food.service;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dlog.diary.common.domain.food.FoodNutrition;
import com.dlog.diary.common.domain.food.FoodNutritions;
import com.dlog.diary.food.dto.FoodNutritionResponse;
import com.dlog.diary.food.dto.FoodNutritionServiceBodyItem;
import com.dlog.diary.food.dto.FoodNutritionServiceResponse;
import com.dlog.diary.food.dto.FoodNutritionsResponse;

@Mapper(componentModel = "spring")
public interface FoodNutritionMapping {

	default FoodNutritionsResponse foodNutritionsToResponse(FoodNutritions foodNutrition) {
		List<FoodNutrition> foodNutritions = foodNutrition.getFoodNutritions();
		List<FoodNutritionResponse> foods = new ArrayList<>();
		for (FoodNutrition futrition : foodNutritions) {
			foods.add(foodNutritionToResponse(futrition));
		}

		FoodNutritionsResponse response = new FoodNutritionsResponse();
		response.setFoods(foods);
		response.setTotalCount(foodNutrition.getTotalCount());
		return response;
	}

	@Mappings({ 
		@Mapping(target = "name", source = "food.foodName")
	})
	FoodNutritionResponse foodNutritionToResponse(FoodNutrition food);
	
	default FoodNutritions responseToFoodNutiritions(FoodNutritionServiceResponse response) {
		FoodNutritions foodNutrition = new FoodNutritions();

		List<FoodNutrition> foodNutritions = new ArrayList<>();
		for (FoodNutritionServiceBodyItem item : response.getBody().getItems()) {
			foodNutritions.add(responseItemToFoodNutrition(item));
		}

		foodNutrition.setFoodNutritions(foodNutritions);
		foodNutrition.setTotalCount(Integer.parseInt(response.getBody().getTotalCount()));
		return foodNutrition;
	}
	
	@Mappings({ 
		@Mapping(target = "foodName", source = "item.DESC_KOR"),
		@Mapping(target = "servingSize", source = "item.SERVING_WT"),
		@Mapping(target = "calorie", source = "item.NUTR_CONT1"),
		@Mapping(target = "carbs", source = "item.NUTR_CONT2"),
		@Mapping(target = "protein", source = "item.NUTR_CONT3"),
		@Mapping(target = "fat", source = "item.NUTR_CONT4"),
		@Mapping(target = "sugar", source = "item.NUTR_CONT5"),
		@Mapping(target = "sodium", source = "item.NUTR_CONT6"),
		@Mapping(target = "cholesterol", source = "item.NUTR_CONT7"),
		@Mapping(target = "fattyAcids", source = "item.NUTR_CONT8"),
		@Mapping(target = "transFattyAcids", source = "item.NUTR_CONT9")
	})
	FoodNutrition responseItemToFoodNutrition(FoodNutritionServiceBodyItem item);
}

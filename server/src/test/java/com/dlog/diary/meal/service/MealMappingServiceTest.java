package com.dlog.diary.meal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.meal.dto.DailyMealResponse;
import com.dlog.diary.meal.dto.FoodResponse;

public class MealMappingServiceTest {

	MealMappingService mapper = Mappers.getMapper(MealMappingService.class);

	@Test
	public void test1() {
		int diarySequence = 1;
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String modifyDate = sdf.format(today);
		String diaryDay = "20200719";

		DailyMeals dailyMeals = new DailyMeals();
		dailyMeals.setDiarySequence(diarySequence);
		dailyMeals.setDiaryDayForm(diaryDay);
		dailyMeals.setModifyDate(new Date());
		DailyMealResponse result = mapper.test(dailyMeals);

		DailyMealResponse expected = new DailyMealResponse();
		expected.setDiarySequence(diarySequence);
		expected.setDiaryDay(diaryDay);
		expected.setLastUpdateDate(modifyDate);

		assertEquals(expected.getDiarySequence(), result.getDiarySequence());
		assertEquals(expected.getDiaryDay(), result.getDiaryDay());
		assertEquals(expected.getLastUpdateDate(), result.getLastUpdateDate());
	}

	@Test
	public void test2() {
		int mealDiarySequence = 1;
		int foodSequence = 1;
		String foodName = "사과";
		int calorie = 130;
		String carbs = "33.2";
		String fat = "12.1";
		String protein = "9.2";
		String amount = "150";
		String amountUnit = "g";

		Food food = new Food();
		food.setFoodSequence(foodSequence);
		food.setMealDiarySequence(mealDiarySequence);
		food.setFoodName(foodName);
		food.setCalorie(calorie);
		food.setCarbs(carbs);
		food.setFat(fat);
		food.setProtein(protein);
		food.setAmount(amount);
		food.setAmountUnit(amountUnit);

		FoodResponse foodResponse = new FoodResponse();
		foodResponse.setFoodSequence(food.getFoodSequence());
		foodResponse.setFoodName(food.getFoodName());
		foodResponse.setCalorie(food.getCalorie());
		foodResponse.setCarbs(food.getCarbs());
		foodResponse.setFat(food.getFat());
		foodResponse.setProtein(food.getProtein());
		foodResponse.setAmount(food.getAmount());
		foodResponse.setAmountUnit(food.getAmountUnit());

		List<FoodResponse> response = new ArrayList<>();
		response.add(foodResponse);

		List<Food> foods = new ArrayList<>();
		foods.add(food);

		mealDiarySequence = 1;
		foodSequence = 2;
		foodName = "닭가슴살";
		calorie = 430;
		carbs = "83.2";
		fat = "102.1";
		protein = "300.2";
		amount = "430";
		amountUnit = "g";

		food = new Food();
		food.setFoodSequence(foodSequence);
		food.setMealDiarySequence(mealDiarySequence);
		food.setFoodName(foodName);
		food.setCalorie(calorie);
		food.setCarbs(carbs);
		food.setFat(fat);
		food.setProtein(protein);
		food.setAmount(amount);
		food.setAmountUnit(amountUnit);
		foods.add(food);

		foodResponse = new FoodResponse();
		foodResponse.setFoodSequence(food.getFoodSequence());
		foodResponse.setFoodName(food.getFoodName());
		foodResponse.setCalorie(food.getCalorie());
		foodResponse.setCarbs(food.getCarbs());
		foodResponse.setFat(food.getFat());
		foodResponse.setProtein(food.getProtein());
		foodResponse.setAmount(food.getAmount());
		foodResponse.setAmountUnit(food.getAmountUnit());

		response.add(foodResponse);

		List<FoodResponse> result = mapper.foodsToResponse(foods);
		assertEquals(response.get(0).getFoodSequence(), result.get(0).getFoodSequence());
		assertEquals(response.get(0).getFoodName(), result.get(0).getFoodName());
		assertEquals(response.get(0).getCalorie(), result.get(0).getCalorie());
		assertEquals(response.get(0).getCarbs(), result.get(0).getCarbs());
		assertEquals(response.get(0).getFat(), result.get(0).getFat());
		assertEquals(response.get(0).getProtein(), result.get(0).getProtein());
		assertEquals(response.get(0).getAmount(), result.get(0).getAmount());
		assertEquals(response.get(0).getAmountUnit(), result.get(0).getAmountUnit());
		
		assertEquals(response.get(1).getFoodSequence(), result.get(1).getFoodSequence());
		assertEquals(response.get(1).getFoodName(), result.get(1).getFoodName());
		assertEquals(response.get(1).getCalorie(), result.get(1).getCalorie());
		assertEquals(response.get(1).getCarbs(), result.get(1).getCarbs());
		assertEquals(response.get(1).getFat(), result.get(1).getFat());
		assertEquals(response.get(1).getProtein(), result.get(1).getProtein());
		assertEquals(response.get(1).getAmount(), result.get(1).getAmount());
		assertEquals(response.get(1).getAmountUnit(), result.get(1).getAmountUnit());
	}
}

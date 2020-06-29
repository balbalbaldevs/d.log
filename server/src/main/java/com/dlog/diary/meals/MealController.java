package com.dlog.diary.meals;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dlog.diary.meals.dto.DailyMealResponse;
import com.dlog.diary.meals.dto.FoodsResponse;
import com.dlog.diary.meals.dto.MealResponse;

import io.swagger.annotations.Api;

@RestController
@Api(value = "swag-rest-controller", description = "식단 관련 API")
public class MealController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/diaries/{date}/meals")
	@ResponseBody
	public DailyMealResponse getDailyMeals(@PathVariable("date") String date) {
		return getDailyMealsMockData(date);
	}

	private DailyMealResponse getDailyMealsMockData(String date) {
		DailyMealResponse dailyMeals = new DailyMealResponse();
		dailyMeals.setDate(date);
		dailyMeals.setTotalCalories(1200);
		List<MealResponse> meals = new ArrayList<>();
		MealResponse meal = new MealResponse();
		meal.setMealType("B");
		meal.setMealCalories(400);
		meal.setMealPhotoPath("");

		List<FoodsResponse> foods = new ArrayList<>();
		FoodsResponse food = new FoodsResponse();
		food.setFoodName("닭가슴살");
		food.setCalorie(100);
		food.setCarbs(30);
		food.setFat(20);
		food.setProtein(100);
		food.setAmount(150);
		food.setAmountUnit("g");
		foods.add(food);
		meal.setFoods(foods);
		meals.add(meal);

		meal = new MealResponse();
		meal.setMealType("L");
		meal.setMealCalories(400);
		meal.setMealPhotoPath("");
		foods = new ArrayList<>();
		food = new FoodsResponse();
		food.setFoodName("삼겹살");
		food.setCalorie(400);
		food.setCarbs(30);
		food.setFat(100);
		food.setProtein(100);
		food.setAmount(150);
		food.setAmountUnit("g");
		foods.add(food);
		meal.setFoods(foods);
		meals.add(meal);
		dailyMeals.setMeals(meals);

		meal = new MealResponse();
		meal.setMealType("D");
		meal.setMealCalories(400);
		meal.setMealPhotoPath("");
		foods = new ArrayList<>();
		food = new FoodsResponse();
		food.setFoodName("방울 토마토");
		food.setCalorie(100);
		food.setCarbs(90);
		food.setFat(10);
		food.setProtein(0);
		food.setAmount(100);
		food.setAmountUnit("g");
		foods.add(food);
		food = new FoodsResponse();
		food.setFoodName("샐러리");
		food.setCalorie(100);
		food.setCarbs(90);
		food.setFat(5);
		food.setProtein(5);
		food.setAmount(90);
		food.setAmountUnit("g");
		foods.add(food);
		food = new FoodsResponse();
		food.setFoodName("단호박");
		food.setCalorie(100);
		food.setCarbs(85);
		food.setFat(15);
		food.setProtein(0);
		food.setAmount(110);
		food.setAmountUnit("g");
		foods.add(food);
		meal.setFoods(foods);
		meals.add(meal);
		dailyMeals.setMeals(meals);
		return dailyMeals;
	}

}

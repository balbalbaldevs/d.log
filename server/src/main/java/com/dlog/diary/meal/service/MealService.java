package com.dlog.diary.meal.service;

import org.springframework.stereotype.Service;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.common.domain.meal.Meal;
import com.dlog.diary.common.domain.meal.MealDetail;
import com.dlog.diary.meal.mapper.MealMapper;

@Service
public class MealService {
	private MealMapper mealMapper;

	public MealService(MealMapper mealMapper) {
		this.mealMapper = mealMapper;
	}

	public boolean saveDailyMeal(Meal meal) {
		return mealMapper.insertMeals(meal) > 0;
	}

	public boolean saveMealDetail(MealDetail meals) {
		return mealMapper.insertMealDetail(meals) > 0;
	}

	public boolean saveFood(Food food) {
		return mealMapper.insertFood(food) > 0;
	}

	public boolean saveMeals(DailyMeals meals) {
		boolean isSuccess = saveDailyMeal(null);
		if (isSuccess) {
			isSuccess = saveMealDetail(null);
			if (isSuccess) {
				isSuccess = saveFood(null);
			}
		}
		return false;
	}

	public DailyMeals getDailyMeals(String date) {
		DailyMeals dailyMeals = new DailyMeals();
		Meal meal = mealMapper.selectMeal(date);
		dailyMeals.setMealId(meal.getMealId());
		dailyMeals.setRegDtForm(meal.getRegDtForm());
		dailyMeals.setTotalCalorie(meal.getTotalCalorie());
		dailyMeals.setUserId(meal.getUserId());
		dailyMeals.setRegDt(meal.getRegDt());
		return dailyMeals;
	}

}

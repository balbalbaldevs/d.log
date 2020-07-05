package com.dlog.diary.meal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dlog.diary.common.domain.meal.DailyMealDetail;
import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Meal;
import com.dlog.diary.meal.mapper.MealMapper;

@Service
public class MealService {
	private MealMapper mealMapper;

	public MealService(MealMapper mealMapper) {
		this.mealMapper = mealMapper;
	}

	public boolean saveMeals(DailyMeals meals) {
		mealMapper.insertMealDiary(null);
		mealMapper.insertMealDetail(null);
		mealMapper.insertFood(null);
		return true;
	}

	public DailyMeals getDailyMeals(String date) {
		DailyMeals dailyMeals = new DailyMeals();
		Meal meal = mealMapper.selectMealDiary(date);
		dailyMeals.setMealId(meal.getMealId());
		dailyMeals.setRegDtForm(meal.getRegDtForm());
		dailyMeals.setTotalCalorie(meal.getTotalCalorie());
		dailyMeals.setUserId(meal.getUserId());
		dailyMeals.setRegDt(meal.getRegDt());

		List<DailyMealDetail> mealDetails = mealMapper.selectMealDetail(date);
		dailyMeals.setMealDetails(mealDetails);

		return dailyMeals;
	}

	// TODO Transaction 처리에 따라서 분기처리 할지 호출만 할지 정해야함.
	public boolean editMeals(Object object) {
		mealMapper.updateMealDiary(null);
		mealMapper.updateMealDetail(null);
		mealMapper.updateFood(null);
		return true;
	}

	// TODO Transaction 처리에 따라서 분기처리 할지 호출만 할지 정해야함.
	public boolean removeMeals(String date) {
		boolean isSuccess = mealMapper.deleteMealDiary(date) > 0;
		if (isSuccess) {
			isSuccess = mealMapper.deleteMealDetail(date) > 0;
			if (isSuccess) {
				isSuccess = mealMapper.deleteFood(date) > 0;
			}
		}
		return isSuccess;
	}

}

package com.dlog.diary.meal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlog.diary.common.domain.Diary;
import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.meal.mapper.MealMapper;

@Service
public class MealService {
	private MealMapper mealMapper;

	public MealService(MealMapper mealMapper) {
		this.mealMapper = mealMapper;
	}

	@Transactional
	public boolean registerDiaryMeals(String uniqueId, String diaryDay, List<DailyMeals> dailyMeals) {
		Diary diary = new Diary();
		diary.setUniqueId(uniqueId);
		diary.setDiaryDayForm(diaryDay);
		mealMapper.insertDiary(diary);

		for (DailyMeals mealDiary : dailyMeals) {
			mealDiary.setDiarySequence(diary.getDiarySequence());
			mealMapper.insertMealDiary(mealDiary);
			for (Food food : mealDiary.getFoods()) {
				food.setMealDiarySequence(mealDiary.getMealDiarySequence());
				mealMapper.insertFood(food);
			}
		}
		return true;
	}

	public boolean isNotExist(String uniqueId, String diaryDay) {
		return !isExist(uniqueId, diaryDay);
	}

	public boolean isExist(String uniqueId, String diaryDay) {
		Diary diary = mealMapper.selectDiary(uniqueId, diaryDay);
		return diary != null && diary.getDiarySequence() > 0;
	}

	public List<DailyMeals> getDailyMeals(String uniqueId, String diaryDay) {
		List<DailyMeals> meals = mealMapper.selectDailyMeals(uniqueId, diaryDay);
		for (DailyMeals dailyMeals : meals) {
			List<Food> foods = getFoods(dailyMeals.getMealDiarySequence());
			dailyMeals.setFoods(foods);
		}
		return meals;
	}

	public List<Food> getFoods(int mealDiarySequence) {
		return mealMapper.selectFoods(mealDiarySequence);
	}

	@Transactional
	public boolean editDailyMeals(String uniqueId, String diaryDay, List<DailyMeals> dailyMeals) {
		boolean isSuccess = mealMapper.updateDiary(uniqueId, diaryDay) > 0;
		Diary diary = mealMapper.selectDiary(uniqueId, diaryDay);
		
		// TODO 분기처리 없이 mapper.xml에서 mealDiarySequence 가져오기
		for (DailyMeals meal : dailyMeals) {
			meal.setDiarySequence(diary.getDiarySequence());

			if (meal.getMealDiarySequence() > 0) {
				isSuccess = mealMapper.updateMealDiary(meal) > 0;
			} else {
				isSuccess = mealMapper.insertMealDiary(meal) > 0;
			}

			for (Food food : meal.getFoods()) {
				food.setMealDiarySequence(meal.getMealDiarySequence());

				if (food.getFoodSequence() > 0) {
					isSuccess = mealMapper.updateFood(food) > 0;
				} else {
					isSuccess = mealMapper.insertFood(food) > 0;
				}
			}
		}
		return isSuccess;
	}

	@Transactional
	public boolean removeDiary(String uniqueId, String diaryDay) {
		boolean isSuccess = mealMapper.deleteFoods(uniqueId, diaryDay) > 0;
		if (isSuccess) {
			isSuccess = mealMapper.deleteMealDiaries(uniqueId, diaryDay) > 0;
			if (isSuccess) {
				isSuccess = mealMapper.deleteDiary(uniqueId, diaryDay) > 0;
			}
		}
		return isSuccess;
	}

}

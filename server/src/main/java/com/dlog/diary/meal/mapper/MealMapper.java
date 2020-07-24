package com.dlog.diary.meal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dlog.diary.common.domain.Diary;
import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.common.domain.meal.MealDiary;

@Mapper
@Repository
public interface MealMapper {

	int insertDiary(Diary diary);

	int insertMealDiary(MealDiary mealDiary);

	int insertFood(Food food);

	Diary selectDiary(@Param(value = "uniqueId") String uniqueId, @Param(value = "diaryDay") String diaryDay);

	List<DailyMeals> selectDailyMeals(@Param(value = "uniqueId") String uniqueId,
			@Param(value = "diaryDay") String diaryDay);

	List<Food> selectFoods(int mealDiaryId);

	int updateDiary(@Param(value = "uniqueId") String uniqueId, @Param(value = "diaryDay") String diaryDay);

	int updateMealDiary(DailyMeals dailyMeals);

	int updateFood(Food food);

	int deleteDiary(@Param(value = "uniqueId") String uniqueId, @Param(value = "diaryDay") String diaryDay);

	int deleteMealDiaries(@Param(value = "uniqueId") String uniqueId, @Param(value = "diaryDay") String diaryDay);

	int deleteFoods(@Param(value = "uniqueId") String uniqueId, @Param(value = "diaryDay") String diaryDay);

}

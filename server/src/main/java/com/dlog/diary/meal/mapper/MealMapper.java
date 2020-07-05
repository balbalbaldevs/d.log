package com.dlog.diary.meal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dlog.diary.common.domain.meal.DailyMealDetail;
import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.common.domain.meal.Meal;
import com.dlog.diary.common.domain.meal.MealDetail;

@Mapper
@Repository
public interface MealMapper {

	int insertMealDiary(Meal meal);

	int insertMealDetail(MealDetail mealDetail);

	int insertFood(Food food);

	Meal selectMealDiary(String date);

	List<DailyMealDetail> selectMealDetail(String date);

	List<Food> selectFood(String date);

	int updateMealDiary(Object object);

	int updateMealDetail(Object object);

	int updateFood(Object object);

	int deleteMealDiary(String date);

	int deleteMealDetail(String date);

	int deleteFood(String date);
}

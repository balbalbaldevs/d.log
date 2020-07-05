package com.dlog.diary.meal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dlog.diary.common.domain.meal.Food;
import com.dlog.diary.common.domain.meal.Meal;
import com.dlog.diary.common.domain.meal.MealDetail;

@Mapper
@Repository
public interface MealMapper {

	int insertMeals(Meal meal);

	int insertMealDetail(MealDetail mealDetail);

	int insertFood(Food food);

	Meal selectMeal(String date);
}

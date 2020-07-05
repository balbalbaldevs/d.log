package com.dlog.diary.common.domain.meal;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DailyMealDetail extends MealDetail {
	private List<Food> foods;
}

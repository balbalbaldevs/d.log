package com.dlog.diary.common.domain.food;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FoodNutritions {
	private List<FoodNutrition> foodNutritions;
	private int totalCount;
}

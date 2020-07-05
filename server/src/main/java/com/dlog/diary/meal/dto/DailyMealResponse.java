package com.dlog.diary.meal.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DailyMealResponse {
	@ApiModelProperty(required = true, value = "식단 일자", example = "'20200701'")
	private String date;
	@ApiModelProperty(required = true, value = "총 섭취 칼로리", example = "1200")
	private int totalCalories;
	@ApiModelProperty(required = true, value = "식단 목록")
	private List<MealResponse> meals;
}
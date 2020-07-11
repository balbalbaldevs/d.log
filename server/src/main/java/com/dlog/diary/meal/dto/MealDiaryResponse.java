package com.dlog.diary.meal.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class MealDiaryResponse {
	@ApiModelProperty(required = true, value = "식단 시퀀스", example = "123")
	private int mealDiarySequence;
	@ApiModelProperty(required = true, value = "식사 종류 : BREAKFAST, LUNCH, DINNER, SNACK", example = "BREAKFAST")
	private String mealType;
	@ApiModelProperty(required = true, value = "식사 총 섭취 칼로리", example = "400")
	private int mealCalories;
	@ApiModelProperty(required = true, value = "식사 사진 경로", example = "/20200701/photo/breakfast.png")
	private String mealPhotoPath;
	@ApiModelProperty(required = true, value = "섭취한 음식 목록")
	private List<FoodResponse> foods;
}

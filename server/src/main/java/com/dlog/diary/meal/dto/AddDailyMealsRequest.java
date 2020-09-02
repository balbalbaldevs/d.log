package com.dlog.diary.meal.dto;

import java.util.List;

import com.dlog.diary.common.types.MealType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AddDailyMealsRequest {
	@ApiModelProperty(required = true, value = "식사 사진 경로", example = "/20200701/photo/breakfast.png")
	private String photoPath;
	@ApiModelProperty(required = true, value = "식사 종류 : BREAKFAST, LUNCH, DINNER, SNACK", example = "BREAKFAST")
	private MealType mealType;
	@ApiModelProperty(required = true, value = "섭취한 음식 목록")
	private List<AddFoodRequest> foods;
}

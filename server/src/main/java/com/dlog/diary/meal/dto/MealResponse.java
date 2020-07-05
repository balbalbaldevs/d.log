package com.dlog.diary.meal.dto;

import java.util.List;

import com.dlog.diary.common.types.MealType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class MealResponse {
	@ApiModelProperty(required = true, value = "식사 종류, B:아침, L:점심, D:저녁, S:간식", example = "B")
	private MealType mealType;
	@ApiModelProperty(required = true, value = "식사 총 섭취 칼로리", example = "400")
	private int mealCalories;
	@ApiModelProperty(required = true, value = "식사 사진 경로", example = "/20200701/photo/breakfast.png")
	private String mealPhotoPath;
	@ApiModelProperty(required = true, value = "섭취한 음식 목록")
	private List<FoodsResponse> foods;
}

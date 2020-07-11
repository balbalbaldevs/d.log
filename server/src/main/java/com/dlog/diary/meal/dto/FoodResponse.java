package com.dlog.diary.meal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FoodResponse {
	@ApiModelProperty(required = true, value = "음식 시퀀스", example = "456")
	private int foodSequence;
	@ApiModelProperty(required = true, value = "음식 이름", example = "'닭가슴살'")
	private String foodName;
	@ApiModelProperty(required = true, value = "칼로리", example = "400")
	private int calorie;
	@ApiModelProperty(required = true, value = "탄수화물", example = "'40.2'")
	private String carbs;
	@ApiModelProperty(required = true, value = "단백질", example = "'200'")
	private String protein;
	@ApiModelProperty(required = true, value = "지방", example = "'0.5'")
	private String fat;
	@ApiModelProperty(required = true, value = "섭취량", example = "'400'")
	private String amount;
	@ApiModelProperty(required = true, value = "섭취량 단위", example = "'g'")
	private String amountUnit;
}
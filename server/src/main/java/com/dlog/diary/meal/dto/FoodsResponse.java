package com.dlog.diary.meal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FoodsResponse {
	@ApiModelProperty(required = true, value = "음식 이름", example = "닭가슴살")
	private String foodName;
	@ApiModelProperty(required = true, value = "칼로리", example = "400")
	private int calorie;
	@ApiModelProperty(required = true, value = "탄수화물", example = "40.2")
	private int carbs;
	@ApiModelProperty(required = true, value = "단백질", example = "200")
	private int protein;
	@ApiModelProperty(required = true, value = "지방", example = "0.5")
	private int fat;
	@ApiModelProperty(required = true, value = "섭취량", example = "400")
	private int amount;
	@ApiModelProperty(required = true, value = "섭취량 단위", example = "g")
	private String amountUnit;
}
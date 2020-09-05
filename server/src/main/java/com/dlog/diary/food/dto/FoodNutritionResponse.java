package com.dlog.diary.food.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FoodNutritionResponse {
	@ApiModelProperty(required = true, value = "식품이름", example = "바나나칩")
	private String name;
	@ApiModelProperty(required = true, value = "열량(Kcal)", example = "49.5")
	private String calorie;
	@ApiModelProperty(required = true, value = "탄수화물(g)", example = "5.4")
	private String carbs;
	@ApiModelProperty(required = true, value = "단백질(g)", example = "0.3")
	private String protein;
	@ApiModelProperty(required = true, value = "지방(g)", example = "3")
	private String fat;
	@ApiModelProperty(required = true, value = "1회제공량(g)", example = "30")
	private String servingSize;
}

package com.dlog.diary.food.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FoodNutritionsResponse {
	@ApiModelProperty(required = true, value = "전체 결과 수", example = "21")
	private int totalCount;
	@ApiModelProperty(required = true, value = "검색 결과")
	private List<FoodNutritionResponse> foods;
}

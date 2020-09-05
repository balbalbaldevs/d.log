package com.dlog.diary.food;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlog.diary.common.domain.food.FoodNutritions;
import com.dlog.diary.food.dto.FoodNutritionsResponse;
import com.dlog.diary.food.service.FoodNutritionMapping;
import com.dlog.diary.food.service.FoodNutritionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("식품 영양 조회 API")
public class FoodNutritionController {
	private FoodNutritionService foodNutritionService;
	private FoodNutritionMapping foodNutritionMapping;

	public FoodNutritionController(FoodNutritionService foodNutritionService, FoodNutritionMapping foodNutritionMapping) {
		this.foodNutritionService = foodNutritionService;
		this.foodNutritionMapping = foodNutritionMapping;
	}

	@GetMapping("/foods")
	@ApiOperation(value = "식품 영양성분 조회", notes = "특정 식품의 영양 성분을 공공데이터포털 API를 활용하여  조회.")
	public FoodNutritionsResponse getFoodNutrition(
			@ApiParam(name = "foodName", value = "식품 이름", required = true, example = "바나나칩") @RequestParam String foodName,
			@ApiParam(name = "pageNo", value = "페이지 번호", required = true, example = "1") @RequestParam String pageNo,
			@ApiParam(name = "numOfRows", value = "검색 건수", required = true, example = "10") @RequestParam String numOfRows) {

		FoodNutritions foodNutritions = foodNutritionService.getFoodNutritions(pageNo, numOfRows, foodName);
		FoodNutritionsResponse response = foodNutritionMapping.foodNutritionsToResponse(foodNutritions);
		return response;
	}
}

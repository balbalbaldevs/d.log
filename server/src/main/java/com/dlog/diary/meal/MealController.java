package com.dlog.diary.meal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlog.diary.common.dto.CommonResponse;
import com.dlog.diary.meal.dto.DailyMealResponse;
import com.dlog.diary.meal.dto.DailyMealsRequest;
import com.dlog.diary.meal.dto.GoveFoodsResponse;
import com.dlog.diary.meal.service.MealMockDataService;
import com.dlog.diary.meal.service.MealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("식단 관련 API")
public class MealController {
	private MealMockDataService mockService;
	private MealService mealService;

	public MealController(MealMockDataService mockService, MealService mealService) {
		this.mockService = mockService;
		this.mealService = mealService;
	}

	@GetMapping("/diaries/{date}/meals")
	@ApiOperation(value = "특정일자 식단 조회", notes = "특정일자의 등록된 식단 리스트를 조회.")
	public DailyMealResponse getDailyMeals(
			@ApiParam(name = "date", value = "식단 날짜", required = true, example = "20200701") @PathVariable("date") String date) {

		mealService.getDailyMeals(date);
		// TODO transfer dailyMeals to response

		return mockService.getDailyMealsMockData(date);
	}

	@GetMapping("/foods")
	@ApiOperation(value = "식품 조회", notes = "공공데이터포털 API를 활용한 식품 조회. totalCount가 포털에서 내려주지 않는 오류 있음.")
	public GoveFoodsResponse getFoods(
			@ApiParam(name = "foodName", value = "식품 이름", required = true, example = "바나나칩") @RequestParam String foodName,
			@ApiParam(name = "pageNo", value = "페이지 번호", required = true, example = "1") @RequestParam String pageNo,
			@ApiParam(name = "numOfRows", value = "검색 건수", required = true, example = "10") @RequestParam String numOfRows)
			throws Exception {
		return mockService.getFoods(foodName, pageNo, numOfRows);
	}

	@PostMapping("/diaries/{date}/meals")
	@ApiOperation(value = "식단 등록", notes = "식단 등록.")
	public CommonResponse saveMeals(@RequestBody DailyMealsRequest dayilyMeals) {
		boolean isSuccess = mealService.saveMeals(null);
		CommonResponse response = new CommonResponse();
		if (isSuccess) {
			response.ok(201, "등록 되었습니다.");
		} else {
			response.fail(500, "등록이 실패되었습니다.");
		}
		return response;
	}
}

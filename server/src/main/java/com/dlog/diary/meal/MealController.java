package com.dlog.diary.meal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.common.dto.CommonResponse;
import com.dlog.diary.meal.dto.AddDailyMealsRequest;
import com.dlog.diary.meal.dto.DailyMealResponse;
import com.dlog.diary.meal.dto.EditDailyMealsRequest;
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
	private String uniqueId = "test";

	public MealController(MealMockDataService mockService, MealService mealService) {
		this.mockService = mockService;
		this.mealService = mealService;
	}

	@GetMapping("/diaries/{diaryDay}/meals")
	@ApiOperation(value = "특정일자 식단 조회", notes = "특정일자의 등록된 식단 리스트를 조회.")
	public DailyMealResponse getDailyMeals(
			@ApiParam(name = "diaryDay", value = "식단 날짜", required = true, example = "20200701") @PathVariable("diaryDay") String diaryDay) {

		List<DailyMeals> dailyMeals = mealService.getDailyMeals(uniqueId, diaryDay);
		// TODO transfer dailyMeals to response
		// TODO logging response

		DailyMealResponse response = new DailyMealResponse();
		if (dailyMeals.size() > 0) {
			response.setDailyMeals(dailyMeals);
		} else {
			response.setEmpty();
		}
		return response;
	}

	// TODO API mapping
	@GetMapping("/foods")
	@ApiOperation(value = "식품 조회", notes = "공공데이터포털 API를 활용한 식품 조회. totalCount가 포털에서 내려주지 않는 오류 있음.")
	public GoveFoodsResponse getFoods(
			@ApiParam(name = "foodName", value = "식품 이름", required = true, example = "바나나칩") @RequestParam String foodName,
			@ApiParam(name = "pageNo", value = "페이지 번호", required = true, example = "1") @RequestParam String pageNo,
			@ApiParam(name = "numOfRows", value = "검색 건수", required = true, example = "10") @RequestParam String numOfRows)
			throws Exception {
		return mockService.getFoods(foodName, pageNo, numOfRows);
	}

	@PostMapping("/diaries/{diaryDay}/meals")
	@ApiOperation(value = "식단 등록", notes = "식단 등록.")
	public CommonResponse saveMeals(
			@ApiParam(name = "diaryDay", value = "식단 날짜", required = true, example = "20200701") @PathVariable("diaryDay") String diaryDay,
			@ApiParam(name = "addDailyMealsRequest", value = "등록 할 식단 정보", required = true) @RequestBody List<AddDailyMealsRequest> addDailyMealsRequest) {

		// TODO logging request

		CommonResponse response = new CommonResponse();
		if (mealService.isExist(uniqueId, diaryDay)) {
			response.fail(401, "해당 날짜에 이미 식단 다이어리가 등록되어 있습니다.");
			return response;
		}

		List<DailyMeals> dailyMeals = new ArrayList<>();
		for (AddDailyMealsRequest request : addDailyMealsRequest) {
			dailyMeals.add(request.getDailyMeals(uniqueId, diaryDay));
		}

		boolean isSuccess = mealService.registerDiaryMeals(dailyMeals);
		if (isSuccess) {
			response.ok(201, "등록 되었습니다.");
		} else {
			response.fail(500, "등록이 실패되었습니다.");
		}
		return response;
	}

	@PutMapping("/diaries/{diaryDay}/meals")
	@ApiOperation(value = "식단 수정", notes = "식단 수정.")
	public CommonResponse editDailyMeals(
			@ApiParam(name = "diaryDay", value = "식단 날짜", required = true, example = "20200701") @PathVariable("diaryDay") String diaryDay,
			@ApiParam(name = "editDailyMealsRequest", value = "수정 할 식단 정보", required = true) @RequestBody List<EditDailyMealsRequest> editDailyMealsRequest) {

		CommonResponse response = new CommonResponse();
		if (mealService.isNotExist(uniqueId, diaryDay)) {
			response.fail(401, "해당 날짜에 식단 다이어리가 존재하지 않습니다.");
			return response;
		}

		List<DailyMeals> dailyMeals = new ArrayList<>();
		for (EditDailyMealsRequest request : editDailyMealsRequest) {
			dailyMeals.add(request.getDailyMeals(uniqueId, diaryDay));
		}

		boolean isSuccess = mealService.editDailyMeals(dailyMeals);
		if (isSuccess) {
			response.ok(200, "수정 되었습니다.");
		} else {
			response.fail(500, "수정이 실패되었습니다.");
		}
		return response;
	}

	@DeleteMapping("/diaries/{diaryDay}/meals")
	@ApiOperation(value = "식단 삭제", notes = "식단 삭제.")
	public CommonResponse removeDiary(
			@ApiParam(name = "diaryDay", value = "삭제 할 식단 일자", required = true, example = "20200701") @PathVariable("diaryDay") String diaryDay) {

		CommonResponse response = new CommonResponse();
		if (mealService.isNotExist(uniqueId, diaryDay)) {
			response.fail(401, "해당 날짜에 식단 다이어리가 존재하지 않습니다.");
			return response;
		}

		boolean isSuccess = mealService.removeDiary(uniqueId, diaryDay);
		if (isSuccess) {
			response.ok();
		} else {
			response.fail(500, "삭제가 실패되었습니다.");
		}
		response.ok();
		return response;
	}

}

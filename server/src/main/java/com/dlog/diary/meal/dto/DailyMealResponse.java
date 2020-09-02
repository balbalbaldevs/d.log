package com.dlog.diary.meal.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DailyMealResponse {
	@ApiModelProperty(required = true, value = "다이어리 시퀀스", example = "1")
	private int diarySequence;
	@ApiModelProperty(required = true, value = "식단 일자", example = "'20200701'")
	private String diaryDay;
	@ApiModelProperty(required = true, value = "최종 수정일자", example = "'20200701'")
	private String lastUpdateDate;
	@ApiModelProperty(required = true, value = "총 섭취 칼로리", example = "1200")
	private int totalCalories;
	@ApiModelProperty(required = true, value = "식단 목록")
	private List<MealDiaryResponse> mealDiaries = new ArrayList<>();

	public void setEmpty() {
		this.diarySequence = 0;
		this.diaryDay = "";
		this.lastUpdateDate = "";
		this.totalCalories = 0;
	}
}
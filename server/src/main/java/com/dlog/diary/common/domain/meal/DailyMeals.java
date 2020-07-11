package com.dlog.diary.common.domain.meal;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DailyMeals extends MealDiary {
	private int userSequence;
	private String uniqueId;
	private Date diaryDay;
	private String diaryDayForm;
	private List<Food> foods;
}

package com.dlog.diary.meal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.meal.dto.DailyMealResponse;

public class MealMapStructServiceTest {

	MealMapStructService mapper = Mappers.getMapper(MealMapStructService.class);

	@Test
	public void test() {
		int diarySequence = 1;
		String modifyDate = "20200720";
		String diaryDay = "20200719";

		DailyMeals dailyMeals = new DailyMeals();
		dailyMeals.setDiarySequence(diarySequence);
		dailyMeals.setDiaryDayForm(diaryDay);
		dailyMeals.setModifyDateForm(modifyDate);
		DailyMealResponse result = mapper.to(dailyMeals);

		DailyMealResponse expected = new DailyMealResponse();
		expected.setDiarySequence(diarySequence);
		expected.setDiaryDay(diaryDay);
		expected.setLastUpdateDate(modifyDate);

		assertEquals(expected.getDiarySequence(), result.getDiarySequence());
		assertEquals(expected.getDiaryDay(), result.getDiaryDay());
		assertEquals(expected.getLastUpdateDate(), result.getLastUpdateDate());

	}
}

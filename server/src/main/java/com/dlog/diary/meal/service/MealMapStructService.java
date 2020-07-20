package com.dlog.diary.meal.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dlog.diary.common.domain.meal.DailyMeals;
import com.dlog.diary.meal.dto.DailyMealResponse;

@Mapper(componentModel="spring")
public interface MealMapStructService {

    @Mappings({
        @Mapping(target="diarySequence", source="mailyMeals.diarySequence"),
        @Mapping(target="diaryDay", source="mailyMeals.diaryDayForm"),
        @Mapping(target="lastUpdateDate", source="mailyMeals.modifyDateForm")
      }) 
    DailyMealResponse to(DailyMeals mailyMeals);
}

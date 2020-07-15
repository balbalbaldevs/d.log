package com.dlog.diary.common.domain.meal;

import java.util.Date;

import com.dlog.diary.common.types.MealType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MealDiary {
	private int mealDiarySequence;
	private int diarySequence;
	private MealType mealType;
	private int mealTotalCalorie;
	private String photoPath;
	private String registerDateForm;
	private Date registerDate;
	private String modifyDateForm;
	private Date modifyDate;
}

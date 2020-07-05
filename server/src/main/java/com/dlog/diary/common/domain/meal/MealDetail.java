package com.dlog.diary.common.domain.meal;

import java.util.Date;

import com.dlog.diary.common.types.MealType;

import lombok.Data;

@Data
public class MealDetail {
	private int mealDetailId;
	private int mealId;
	private MealType mealType;
	private int mealTotalCalroie;
	private String photoPath;
	private String regDtForm;
	private Date regDt;
}

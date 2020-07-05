package com.dlog.diary.common.domain.meal;

import java.util.Date;

import lombok.Data;

@Data
public class Meal {
	private int mealId;
	private String userId;
	private String regDtForm;
	private Date regDt;
	private int totalCalorie;
}

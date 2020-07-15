package com.dlog.diary.common.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Diary {
	private int diarySequence;
	private int userSequence;
	private String uniqueId;
	private String diaryDayForm;
	private Date diaryDay;
	private String registerDateForm;
	private Date registerDate;
	private String modifyDateForm;
	private Date modifyDate;
}

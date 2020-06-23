package com.dlog.diary.exercise;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("exerDiary")
@Data
public class ExerDiary {
	
	//운동일기 인덱스
	private int edId;
	//일기 그룹id
	private String edGrId;
	//작성자
	private String userId;
	//제목
	private String title;
	//운동 이름
	private String exerNm;
	//운동 시간
	private int exerTime;
	//예상 소모 칼로리
	private int consumKcal;
	// 개별운동1/기존운동2
	private String edFlag;
	//생성일
	private String regDt;
	
}

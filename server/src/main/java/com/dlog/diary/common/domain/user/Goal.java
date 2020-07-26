package com.dlog.diary.common.domain.user;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.dlog.diary.common.domain.CommonDate;
import com.dlog.diary.common.types.GoalStateType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Alias("goal")
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel
public class Goal extends CommonDate {
	
	@ApiModelProperty(value="목표 ID", example="1")
	private Integer goalSequence;
	
	@ApiModelProperty(required=true, value="사용자 ID", example="1")
	private Integer userSequence;
	
	@ApiModelProperty(required=true, value="제목", example="5kg 감량")
	private String title;
	
	@ApiModelProperty(required=true, value="목표 몸무게", example="50")
	private Integer targetWeight;
	
	@ApiModelProperty(required=true, value="상태", example="TO_DO")
	private GoalStateType state;
	
	@ApiModelProperty(required=true, value="시작일", example="2020-07-01")
	private Date startDate;
	
	@ApiModelProperty(required=true, value="종료일", example="2020-07-09")
	private Date endDate;

}
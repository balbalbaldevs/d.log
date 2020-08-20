package com.dlog.diary.common.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class EnumTypeDto {
	
	private Map<String, String> goalStateType;
	
	private Map<String, String> mealType;
	
	private Map<String, String> unitType;
	
	private Map<String, String> userLoginType;
	
	private Map<String, String> userSexType;

}

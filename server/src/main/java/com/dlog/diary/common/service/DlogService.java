package com.dlog.diary.common.service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.dlog.diary.common.dto.EnumTypeDto;
import com.dlog.diary.common.types.DlogEnum;
import com.dlog.diary.common.types.GoalStateType;
import com.dlog.diary.common.types.MealType;
import com.dlog.diary.common.types.UnitType;
import com.dlog.diary.common.types.UserLoginType;
import com.dlog.diary.common.types.UserSexType;

@Service
public class DlogService {

	private EnumTypeDto enumTypeDto;

	@PostConstruct
	public void init() {
		enumTypeDto = new EnumTypeDto();
		
		enumTypeDto.setGoalStateType(convertEnumtoMap(GoalStateType.class));
		enumTypeDto.setMealType(convertEnumtoMap(MealType.class));
		enumTypeDto.setUnitType(convertEnumtoMap(UnitType.class));
		enumTypeDto.setUserLoginType(convertEnumtoMap(UserLoginType.class));
		enumTypeDto.setUserSexType(convertEnumtoMap(UserSexType.class));
	}
	
	private static <T extends Enum<T> & DlogEnum> Map<String, String> convertEnumtoMap(Class<T> t) {
		return Arrays.asList(t.getEnumConstants()).stream()
				.collect(Collectors.toMap(v -> v.toString(), v -> Enum.valueOf(t, v.toString()).getDescription()));
	}
	
	public EnumTypeDto getEnumTypeDto() {
		return enumTypeDto;
	}
}
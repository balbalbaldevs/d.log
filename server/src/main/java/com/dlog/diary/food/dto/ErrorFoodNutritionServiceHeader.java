package com.dlog.diary.food.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "cmmMsgHeader")
public class ErrorFoodNutritionServiceHeader {
	private String errMsg;
	private String returnAuthMsg;
	private String returnReasonCode;
}

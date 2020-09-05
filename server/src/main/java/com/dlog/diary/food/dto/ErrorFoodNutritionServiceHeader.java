package com.dlog.diary.food.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "cmmMsgHeader")
public class ErrorFoodNutritionServiceHeader {
	private String errMsg;
	private String returnAuthMsg;
	private String returnReasonCode;
	private String returnCode;

	@Override
	public String toString() {
		return "ErrorFoodNutritionServiceHeader [" + (errMsg != null ? "errMsg=" + errMsg + ", " : "")
				+ (returnAuthMsg != null ? "returnAuthMsg=" + returnAuthMsg + ", " : "")
				+ (returnReasonCode != null ? "returnReasonCode=" + returnReasonCode + ", " : "") + (returnCode != null ? "returnCode=" + returnCode : "")
				+ "]";
	}

}

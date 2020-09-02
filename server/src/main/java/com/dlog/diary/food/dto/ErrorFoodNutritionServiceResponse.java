package com.dlog.diary.food.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "OpenAPI_ServiceResponse")
public class ErrorFoodNutritionServiceResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private ErrorFoodNutritionServiceHeader cmmMsgHeader;
}
package com.dlog.diary.food.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "header")
public class FoodNutritionServiceHeader implements Serializable {
	private static final long serialVersionUID = 1L;
	private String resultCode;
	private String resultMsg;
}
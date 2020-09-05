package com.dlog.diary.food.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "item")
public class FoodNutritionServiceBodyItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String DESC_KOR;
	private String SERVING_WT;
	private String NUTR_CONT1;
	private String NUTR_CONT2;
	private String NUTR_CONT3;
	private String NUTR_CONT4;
	private String NUTR_CONT5;
	private String NUTR_CONT6;
	private String NUTR_CONT7;
	private String NUTR_CONT8;
	private String NUTR_CONT9;
	private String BGN_YEAR;
	private String ANIMAL_PLANT;
}

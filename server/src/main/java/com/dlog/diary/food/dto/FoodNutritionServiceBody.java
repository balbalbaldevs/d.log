package com.dlog.diary.food.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "body")
public class FoodNutritionServiceBody implements Serializable {
	private static final long serialVersionUID = 1L;
	private String numOfRows;
	private String pageNo;
	private String totalCount;
	private List<FoodNutritionServiceBodyItem> items;

	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public List<FoodNutritionServiceBodyItem> getItems() {
		return items;
	}
}

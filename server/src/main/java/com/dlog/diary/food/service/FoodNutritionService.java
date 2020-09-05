package com.dlog.diary.food.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import com.dlog.diary.common.domain.food.FoodNutritions;
import com.dlog.diary.food.dto.ErrorFoodNutritionServiceResponse;
import com.dlog.diary.food.dto.FoodNutritionServiceResponse;

@Service
public class FoodNutritionService {
	@Value("${food.api.key}")
	private String FOOD_API_KEY;

	@Value("${food.api.url}")
	private String FOOD_API_URL;
	
	private FoodNutritionMapping foodNutritionMapping;

	public FoodNutritionService(FoodNutritionMapping foodNutritionMapping) {
		this.foodNutritionMapping = foodNutritionMapping;
	}

	public FoodNutritions getFoodNutritions(String pageNo, String numOfRows, String foodName) {
		FoodNutritionServiceResponse response = execute(pageNo, numOfRows, foodName);
		FoodNutritions foodNutrition = foodNutritionMapping.responseToFoodNutiritions(response);
		return foodNutrition;
	}

	public FoodNutritionServiceResponse execute(String pageNo, String numOfRows, String descKor) {
		RestTemplate restTemplate = new RestTemplate();
		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
		defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
		restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FOOD_API_URL)
				.queryParam("ServiceKey", encode(FOOD_API_KEY))
				.queryParam("desc_kor", encode(descKor))
				.queryParam("pageNo", pageNo)
				.queryParam("numOfRows", numOfRows);

		try {
			ResponseEntity<FoodNutritionServiceResponse> response = restTemplate.exchange(builder.build(false).toUriString(), HttpMethod.GET,
					new org.springframework.http.HttpEntity<>(headers), FoodNutritionServiceResponse.class);
			return response.getBody();
		} catch (Exception e) {
			if (e.getMessage().indexOf("OpenAPI_ServiceResponse") > -1) {
				ResponseEntity<ErrorFoodNutritionServiceResponse> response = restTemplate.exchange(builder.build(false).toUriString(), HttpMethod.GET,
						new org.springframework.http.HttpEntity<>(headers), ErrorFoodNutritionServiceResponse.class);
				System.out.println(response);
				
				// TODO Custom Exception 던져서 200 으로 내리면서 에러 메세지 내리도록 처리
			}
			
			e.printStackTrace();
			return null;
		}
	}

	private String encode(String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
}

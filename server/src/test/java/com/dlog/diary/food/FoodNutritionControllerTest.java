package com.dlog.diary.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.dlog.diary.common.util.Tools;
import com.dlog.diary.food.dto.FoodNutritionsResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FoodNutritionControllerTest {
	@LocalServerPort
	private int PORT;
	
	@Autowired
	private TestRestTemplate template;

	@Test
	public void testFoods() throws URISyntaxException {

		String descKor = "진라면";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:" + PORT + "/foods")
				.queryParam("foodName", Tools.encode(descKor))
				.queryParam("pageNo", 1)
				.queryParam("numOfRows", 2);
		System.out.println(builder.build(false).toUriString());

		String queryParam = "foodName="+Tools.encode(descKor)+"&pageNo=1&numOfRows=2";
		URI uri = new URI("http://localhost:" + PORT + "/foods?" + queryParam);

		ResponseEntity<FoodNutritionsResponse> response = template.getForEntity(uri, FoodNutritionsResponse.class);
		FoodNutritionsResponse responseBody = response.getBody();
		
		assertTrue(0 > responseBody.getTotalCount());
		assertEquals(descKor, responseBody.getFoods().get(0).getName());
	}

}

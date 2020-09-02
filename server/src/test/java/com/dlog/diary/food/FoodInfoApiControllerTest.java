package com.dlog.diary.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dlog.diary.food.dto.ErrorFoodNutritionServiceResponse;
import com.dlog.diary.food.dto.FoodNutritionServiceResponse;

@SpringBootTest
public class FoodInfoApiControllerTest {

	@Value("${food.api.key}")
	private String SERVICE_KEY;

	static String URL_ADDRESS = "http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList";

	static StringBuilder urlBuilder = new StringBuilder(URL_ADDRESS); /* URL */
	static {
		urlBuilder.append("?" + encode("desc_kor") + "=" + encode("바나나칩")); /* 식품이름 */
		urlBuilder.append("&" + encode("pageNo") + "=" + encode("1")); /* 페이지번호 */
		urlBuilder.append("&" + encode("numOfRows") + "=" + encode("2")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + encode("bgn_year") + "=" + encode("")); /* 구축년도 */
		urlBuilder.append("&" + encode("animal_plant") + "=" + encode("")); /* 가공업체 */
		urlBuilder.append("&" + encode("ServiceKey") + "="
				+ "EI4x6KTdEA3w3qmHKf8d015fjCT7pb%2BU0g15MvgBD77sPl%2FKwazneXBO1%2FYQUsAhqdmOv2LlsAlSYRm%2FLTm3OA%3D%3D"); /* Service Key */
	}

	@Test
	public void exampleFromTheSite() throws IOException {
		URL url = new URL(urlBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		BufferedReader rd = null;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		System.out.println(sb.toString());
		assertNotNull(sb.toString());
		assertTrue(sb.toString().indexOf("<response><header><resultCode>00</resultCode><resultMsg>NORMAL SERVICE.</resultMsg>") == 0);
	}

	private static String encode(String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Test
	public void testUsingRestTemplate() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ErrorFoodNutritionServiceResponse> response = restTemplate.getForEntity(urlBuilder.toString(), ErrorFoodNutritionServiceResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("30", response.getBody().getCmmMsgHeader().getReturnReasonCode());
	}

	@Test
	public void testUsingHttpClient() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(urlBuilder.toString());
			httpGet.addHeader("accept", "application/xml");

			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity httpEntity = (HttpEntity) response.getEntity();

			String apiOutput = EntityUtils.toString(httpEntity, "UTF-8");

			JAXBContext jaxbContext = JAXBContext.newInstance(FoodNutritionServiceResponse.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FoodNutritionServiceResponse data = (FoodNutritionServiceResponse) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));

			assertEquals("바나나칩", data.getBody().getItems().get(0).getDESC_KOR());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.close();
		}
	}
}

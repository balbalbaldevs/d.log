package com.dlog.diary.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;

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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import com.dlog.diary.common.util.Tools;
import com.dlog.diary.food.dto.ErrorFoodNutritionServiceResponse;
import com.dlog.diary.food.dto.FoodNutritionServiceResponse;

@SpringBootTest
public class FoodInfoApiControllerTest {

	@Value("${food.api.key}")
	private String SERVICE_KEY;

	private String URL_ADDRESS = "http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList";

	@Test
	public void exampleFromTheSite() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(URL_ADDRESS); /* URL */
		urlBuilder.append("?" + Tools.encode("desc_kor") + "=" + Tools.encode("바나나칩")); /* 식품이름 */
		urlBuilder.append("&" + Tools.encode("pageNo") + "=" + Tools.encode("1")); /* 페이지번호 */
		urlBuilder.append("&" + Tools.encode("numOfRows") + "=" + Tools.encode("2")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + Tools.encode("ServiceKey") + "=" + Tools.encode(SERVICE_KEY)); /* Service Key */
		
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

		assertNotNull(sb.toString());
		assertTrue(sb.toString().indexOf("<response><header><resultCode>00</resultCode><resultMsg>NORMAL SERVICE.</resultMsg>") == 0);
	}

	@Test
	public void testUsingRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
		defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
		restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);

		String descKor = "바나나칩";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_ADDRESS)
				.queryParam("ServiceKey", Tools.encode(SERVICE_KEY))
				.queryParam("desc_kor", Tools.encode(descKor))
				.queryParam("pageNo", 1)
				.queryParam("numOfRows", 2);

		try {
			ResponseEntity<FoodNutritionServiceResponse> test = restTemplate.exchange(builder.build(false).toUriString(), HttpMethod.GET, new org.springframework.http.HttpEntity<>(headers),
					FoodNutritionServiceResponse.class);
			
			assertEquals(HttpStatus.OK, test.getStatusCode());
			assertEquals(descKor, test.getBody().getBody().getItems().get(0).getDESC_KOR());
		} catch (Exception e) {
			ResponseEntity<ErrorFoodNutritionServiceResponse> response = restTemplate.exchange(builder.build(false).toUriString(), HttpMethod.GET,
					new org.springframework.http.HttpEntity<>(headers), ErrorFoodNutritionServiceResponse.class);

			System.out.println(response);
			assertTrue(false);
		}
	}

	@Test
	public void testUsingRestTemplateForError() {
		StringBuilder urlBuilder = new StringBuilder(URL_ADDRESS); /* URL */
		urlBuilder.append("?" + Tools.encode("desc_kor") + "=" + Tools.encode("바나나칩")); /* 식품이름 */
		urlBuilder.append("&" + Tools.encode("pageNo") + "=" + Tools.encode("1")); /* 페이지번호 */
		urlBuilder.append("&" + Tools.encode("numOfRows") + "=" + Tools.encode("2")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + Tools.encode("ServiceKey") + "=" + SERVICE_KEY); /* Service Key */
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET, new org.springframework.http.HttpEntity<>(headers),
					FoodNutritionServiceResponse.class);

			assertTrue(false);

		} catch (Exception e) {
			if (e.getMessage().indexOf("OpenAPI_ServiceResponse") > -1) {
				ResponseEntity<ErrorFoodNutritionServiceResponse> test = restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET,
						new org.springframework.http.HttpEntity<>(headers), ErrorFoodNutritionServiceResponse.class);
				
				assertEquals(HttpStatus.OK, test.getStatusCode());
			} else {
				e.printStackTrace();
				assertTrue(false);
			}
		}
	}

	@Test
	public void testUsingHttpClient() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {

			StringBuilder urlBuilder = new StringBuilder(URL_ADDRESS); /* URL */
			urlBuilder.append("?" + Tools.encode("desc_kor") + "=" + Tools.encode("바나나칩")); /* 식품이름 */
			urlBuilder.append("&" + Tools.encode("pageNo") + "=" + Tools.encode("1")); /* 페이지번호 */
			urlBuilder.append("&" + Tools.encode("numOfRows") + "=" + Tools.encode("2")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + Tools.encode("ServiceKey") + "=" + SERVICE_KEY); /* Service Key */
			
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

	@Test
	public void testDecode() throws Exception {
		String s = "EI4x6KTdEA3w3qmHKf8d015fjCT7pb%2BU0g15MvgBD77sPl%2FKwazneXBO1%2FYQUsAhqdmOv2LlsAlSYRm%2FLTm3OA%3D%3D";
		System.out.println(s);

		String decodeS = URLDecoder.decode(s, "UTF-8");
		System.out.println(decodeS);

		String encode = URLEncoder.encode(decodeS, "UTF-8");
		System.out.println(encode);

		assertEquals(s, encode);
	}

	@Test
	public void compareUri() {
		String descKor = "바나나칩";
		int pageNo = 1;
		int numOfRows = 2;
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_ADDRESS)
				.queryParam("desc_kor", Tools.encode(descKor))
				.queryParam("pageNo", pageNo)
				.queryParam("numOfRows", numOfRows)
				.queryParam("ServiceKey", SERVICE_KEY);

		assertNotEquals(builder.toUriString(), builder.build(false).toUriString());

		StringBuilder urlBuilder = new StringBuilder(URL_ADDRESS); /* URL */
		urlBuilder.append("?" + Tools.encode("desc_kor") + "=" + Tools.encode(descKor)); /* 식품이름 */
		urlBuilder.append("&" + Tools.encode("pageNo") + "=" + Tools.encode(pageNo + "")); /* 페이지번호 */
		urlBuilder.append("&" + Tools.encode("numOfRows") + "=" + Tools.encode(numOfRows + "")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + Tools.encode("ServiceKey") + "=" + Tools.encode(SERVICE_KEY)); /* Service Key */
		
		builder = UriComponentsBuilder.fromHttpUrl(URL_ADDRESS)
				.queryParam("desc_kor", Tools.encode(descKor))
				.queryParam("pageNo", pageNo)
				.queryParam("numOfRows", numOfRows)
				.queryParam("ServiceKey", Tools.encode(SERVICE_KEY));

		assertEquals(urlBuilder.toString(), builder.build(false).toUriString());
	}
}

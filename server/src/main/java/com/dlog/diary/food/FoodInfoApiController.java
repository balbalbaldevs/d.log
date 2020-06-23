package com.dlog.diary.food;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.swagger.annotations.Api;

@RestController
@Api(value = "swag-rest-controller", description = "FoodInfoApi")
public class FoodInfoApiController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${food.api.key}")
	private String key;

	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

	/**
	 * 
	 * @param paraStr 예) 라면
	 * @return list<map<string,Object>>
	 * @throws Exception
	 */
	@RequestMapping(value = "/foods", method = RequestMethod.GET)
	@ResponseBody
	public List<?> getFoodInfo(@RequestParam String paraStr) throws Exception {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ key); 
		urlBuilder.append("&" + URLEncoder.encode("bgn_year", "UTF-8") + "="
				+ URLEncoder.encode("2017", "UTF-8")); //자료 구축년도
		
		urlBuilder.append("&" + URLEncoder.encode("desc_kor", "UTF-8") + "="
				+ URLEncoder.encode(paraStr, "UTF-8")); //식품 이름
		
	
		URL url = new URL(urlBuilder.toString());
		try{
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(String.valueOf(url));
				
				//파싱할 tag
				doc.getDocumentElement().normalize();
				
				NodeList nList = doc.getElementsByTagName("item");
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						map = new HashMap<>();
						Element eElement = (Element) nNode;
						logger.info("########### "+temp+" ###########");
						map.put("no",temp+1);
						map.put("nm", getTagValue("DESC_KOR", eElement));
						map.put("kcal", getTagValue("NUTR_CONT1", eElement));
						map.put("car", getTagValue("NUTR_CONT2", eElement));
						map.put("protein", getTagValue("NUTR_CONT3", eElement));
						map.put("fat", getTagValue("NUTR_CONT4", eElement));
						map.put("amount", getTagValue("SERVING_WT", eElement)+'g');
						map.put("processCp", getTagValue("ANIMAL_PLANT", eElement));
						
						logger.info("이름 : " + getTagValue("DESC_KOR", eElement));
						logger.info("칼로리: " + getTagValue("NUTR_CONT1", eElement));
						logger.info("탄수화물: " + getTagValue("NUTR_CONT2", eElement));
						logger.info("단백질: " + getTagValue("NUTR_CONT3", eElement));
						logger.info("지방: " + getTagValue("NUTR_CONT4", eElement));
						logger.info("단위(g)  : " + getTagValue("SERVING_WT", eElement)+"g");
						logger.info("가공업체 : " + getTagValue("ANIMAL_PLANT", eElement));
					}
					list.add(map);
				}//for E
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("API ERROR ======> " + e.getMessage());
		}
		return list;
	}
	
}

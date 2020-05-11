package com.dlog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="swag-rest-controller", description = "SwaggerTestContoller")
public class SwaggerTestController {

	/**
	 * selectList 테스트
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/tests", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> testList(@RequestParam String str) {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "rowId : 1," + str);
		map.put("2", "rowId : 2," + str);
		map.put("3", "rowId : 3," + str);
		map.put("4", "rowId : 4," + str);
		return map;
	}
	
	/**
	 * selectOne 테스트
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/test/{rowId}", method = RequestMethod.GET)
	@ResponseBody
	public String testDetail(@PathVariable String rowId) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("1", "rowId : 1, 첫번째");
		map.put("2", "rowId : 2, 두번째");
		map.put("3", "rowId : 3, 세번째");
		map.put("4", "rowId : 4, 네번째");
		map.get(rowId);
		return String.valueOf(map.get(rowId));
	}
	
	/**
	 * update 테스트
	 * @param rowId
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.PATCH)
	@ResponseBody
	public Map<String, Object> testUpdt(@RequestBody Map<String, Object> paraMap) {
		Map<String, Object> map = new HashMap<>();
		map.put("1", paraMap.get("1"));
		map.put("2", paraMap.get("2"));
		map.put("3", paraMap.get("3"));
		map.put("4", paraMap.get("4"));
		
		return map;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.DELETE)
	@ResponseBody
	public String testDel(@RequestParam String rowId) {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "rowId : 1, 첫번쨰");
		map.put("2", "rowId : 2, 두번쨰");
		map.put("3", "rowId : 3, 세번쨰");
		map.put("4", "rowId : 4, 네번쨰");
		map.remove(rowId);

		if(map.get(rowId) == null || map.get(rowId) == ""){
			return rowId + "번이 삭제 되었습니다";
		}
		
		return "삭제 안됨";
	}
}

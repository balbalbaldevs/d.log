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
	 * GET
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/tests", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> testList(String str) {
		
		if("".equals(str) || str == null){
			str = "test";
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("1", "rowId1 " + str);
		map.put("2", "rowId2 " + str);
		map.put("3", "rowId3 " + str);
		map.put("4", "rowId4 " + str);
		return map;
	}
	
	/**
	 * GET
	 * @param rowId
	 * @return
	 */
	@RequestMapping(value = "/test/{rowId}", method = RequestMethod.GET)
	@ResponseBody
	public String testDetail(@PathVariable String rowId) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("1", "rowId1 111111111111");
		map.put("2", "rowId2 222222222222");
		map.put("3", "rowId3 333333333333");
		map.put("4", "rowId4 444444444444");
		map.get(rowId);
		return String.valueOf(map.get(rowId));
	}
	
	/**
	 * PATCH
	 * @param paraMap
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
	/**
	 * DELETE
	 * @param rowId
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.DELETE)
	@ResponseBody
	public String testDel(@RequestParam String rowId) {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "rowId1 111111111111");
		map.put("2", "rowId2 222222222222");
		map.put("3", "rowId3 333333333333");
		map.put("4", "rowId4 444444444444");
		map.remove(rowId);

		if(map.get(rowId) == null || map.get(rowId) == ""){
			return rowId + " DELETED";
		}
		
		return "rowId 1~4";
	}
	/**
	 * POST
	 * @param paraMap
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> testInst(@RequestBody Map<String, Object> paraMap) {
		return paraMap;
	}
}

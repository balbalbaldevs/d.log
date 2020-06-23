package com.dlog.diary.sample;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="swag-rest-controller", description = "SwaggerSampleController")
public class SwaggerSampleController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SampleMapper sMapper;
	
	/**
	 * GET
	 * @return
	 */
	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> sample() {
		SampleVO sv = new SampleVO();
		sv.setAge("100");
		sv.setNm("심청이");
		
		Map<String, Object> map = sMapper.getSampleData(sv);
		
		logger.info("db 테스트 ====> " + map);
		
		return map;
	}
	
}

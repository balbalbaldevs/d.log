package dlog.diary.test;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="swag-rest-controller", description = "SwaggerTestContoller")
public class SwaggerTestController {

	@Autowired
	testMapper tMapper;
	
	/**
	 * GET
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> test() {
		
		testVO tv = new testVO();
		tv.setAge("100");
		tv.setNm("심청이");
		
		Map<String, Object> map = tMapper.getTestData(tv);
		
		System.out.println("db 테스트 ====> "+map);
		return map;
	}
	
}

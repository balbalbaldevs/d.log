package dlog.diary.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;

@RestController
@Api(value="swag-rest-controller", description = "ExerciseContoller")
public class ExerciseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ExerDiaryMapper edMapper;
	
	/**
	 * 
	 * @param paraStr {"userId":"test", "title":"제목" ,"exerNm":"운동명" ,"exerTime":"1" ,"consumKcal":"1" }
	 * @return
	 */
	@RequestMapping(value = "/exerdiary", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> InstExerDiary(@RequestBody String paraStr) {
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			ObjectMapper om = new ObjectMapper();
			ExerDiary ed = om.readValue(paraStr, ExerDiary.class);
			ed.setEdGrId("ED_"+String.valueOf((int)(Math.random()*1000)+1));
			String r = (edMapper.exerDiaryInst(ed)>0) ? "ok" : "fail";
			result.put("result", r);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("exerController insert ===>"+ e.getMessage());
		}
		
		return result;	
	}
	
	/**
	 * 
	 * @param map 일단 임시
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/exerdiarys", method=RequestMethod.GET)
	@ResponseBody
	public List<?> exerDiaryList(@RequestParam(required=false) Map<String, Object> map) throws Exception{
		return edMapper.exerDiaryList(map);
	}
	
}

package com.dlog.diary.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwaggerSampleControllerTest {

	@Autowired
	SampleMapper sMapper;
	
	@Test
	public void dbConTest() {
		SampleVO sv = new SampleVO();
		sv.setAge("100");
		sv.setNm("심청이");
		
		System.out.println("db 커넥션 테스트 ====> " + sMapper.getSampleData(sv));
	}

}

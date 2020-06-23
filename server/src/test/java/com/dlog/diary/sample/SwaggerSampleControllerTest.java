package com.dlog.diary.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dlog.diary.sample.SampleMapper;
import com.dlog.diary.sample.SampleVO;

@SpringBootTest
@RunWith(SpringRunner.class)
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

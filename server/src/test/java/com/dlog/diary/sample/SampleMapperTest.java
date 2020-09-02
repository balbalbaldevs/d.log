package com.dlog.diary.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SampleMapperTest {

	@Autowired
	SampleMapper sampleMapper;

	@Test
	public void selectTest() {
		String age = "100";
		String name = "심청이";
		String said = "영차영차";

		SampleVO sv = new SampleVO();
		sv.setAge(age);
		sv.setNm(name);
		Map<String, Object> sampleData = sampleMapper.getSampleData(sv);

		assertEquals(age, sampleData.get("age"));
		assertEquals(name, sampleData.get("name"));
		assertEquals(said, sampleData.get("said"));
	}

}

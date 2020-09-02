package com.dlog.diary.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class SampleMappingServiceTest {

	SampleMappingService mapper = Mappers.getMapper(SampleMappingService.class);

	@Test
	public void test() {
		String age = "30";
		String nm = "테스트";

		SampleVO sampleVO = new SampleVO();
		sampleVO.setAge(age);
		sampleVO.setNm(nm);

		SampleResponse response = new SampleResponse();
		response.setAge(sampleVO.getAge());
		response.setName(sampleVO.getNm());

		SampleResponse result = mapper.voToResponse(sampleVO);

		assertEquals(response.getAge(), result.getAge());
		assertEquals(response.getName(), result.getName());
	}
}

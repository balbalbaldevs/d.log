package com.dlog.diary.sample;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SampleMapper {

	public abstract Map<String, Object> getSampleData(SampleVO vo);
	
}

package com.dlog.diary.sample;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SampleMappingService {

	@Mappings({ 
		@Mapping(target = "name", source = "sampleVO.nm"), 
		@Mapping(target = "age", source = "sampleVO.age") 
	})
	SampleResponse voToResponse(SampleVO sampleVO);
}

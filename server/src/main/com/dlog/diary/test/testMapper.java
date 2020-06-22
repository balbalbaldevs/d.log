package dlog.diary.test;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface testMapper {

	public abstract Map<String, Object> getTestData(testVO vo);
	
}

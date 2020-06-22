package dlog.diary.exercise;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExerDiaryMapper {

	//일기 추가
	public abstract Integer exerDiaryInst(ExerDiary ed) throws Exception;
	public abstract List<Map<String,Object>> exerDiaryList(Map<String, Object> map) throws Exception;
}

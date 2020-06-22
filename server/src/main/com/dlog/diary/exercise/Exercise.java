package dlog.diary.exercise;


import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("exercise")
@Data
public class Exercise {
	private int exerId;
	private String exerNm;
	private int exerKcal;
	
}

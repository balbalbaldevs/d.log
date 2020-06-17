package dlog.diary.test;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("test")
@Data
public class testVO {
	private String nm;
	private String age;
	
}

package dlog.diary.sample;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("test")
@Data
public class SampleVO {
	
	private String nm;
	private String age;
	
}

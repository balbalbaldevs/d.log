import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dlog.diary.sample.SampleMapper;
import dlog.diary.sample.SampleVO;

@SpringBootTest
public class ServerApplicationTests {

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

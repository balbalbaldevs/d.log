package dlog.diary.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ServerApplicationTests {

	@Autowired
	testMapper tMapper;
	
	@Test
	public void dbConTest() {
		testVO tv = new testVO();
		tv.setAge("100");
		tv.setNm("심청이");
		
		System.out.println("db 커넥션 테스트 ====> "+tMapper.getTestData(tv));
	}


}

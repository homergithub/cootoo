package cootooweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cootoo.menuManagement.dao.MenuManagementDao;

@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="classpath:spring/spring.xml") // 加载配置
public class DormTest {
	
	@Autowired
	private MenuManagementDao menuManagementDaoImpl;
	
	@Test
	public void testDormService(){
		
		
	}
	
	
}

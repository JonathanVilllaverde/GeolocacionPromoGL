package tracker.com;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Testing dummy instance of mongodb
 * 
 * @author matias.garcia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@ActiveProfiles("test")
public class MongoDbTest {

	@Autowired
	MongoDbFactory mongoDbFactory;
	
	@Test
	public void test(){
		assertNotNull(mongoDbFactory);
	}
}

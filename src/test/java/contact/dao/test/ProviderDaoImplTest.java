package contact.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dispatcher.dao.ProviderDaoImpl;
import dispatcher.entity.Provider;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ProviderDaoImplTest {

	@Autowired
	private ProviderDaoImpl dao;

	@Test
	@Transactional
	public void testCreateAndReadProvider() {
		Provider p = new Provider();
		p.setProviderName("dksjh");
		dao.create(p);
		List<Provider> list = dao.read();
		Assert.assertEquals(p.getProviderName(), list.get(0).getProviderName());
	}

}

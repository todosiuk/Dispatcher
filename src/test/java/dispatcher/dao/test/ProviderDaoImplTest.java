package dispatcher.dao.test;

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

	@Test
	@Transactional
	public void testUpdate() {
		Provider p = new Provider();
		p.setProviderName("ส่ๅโ");
		dao.create(p);
		p.setProviderName("Toronto");
		dao.update(p);
		List<Provider> list = dao.read();
		Assert.assertEquals("Toronto", list.get(0).getProviderName());
	}

	@Test
	@Transactional
	public void testDelete() {
		Provider p = new Provider();
		p.setProviderName("Lviv");
		dao.create(p);
		dao.delete(p.getIdProvider());
		List<Provider> list = dao.read();
		Assert.assertEquals(0, list.size());
	}

	@Test
	@Transactional
	public void testFindById() {
		Provider p = new Provider();
		p.setProviderName("Lviv");
		dao.create(p);
		List<Provider> list = dao.read();
		Integer id = list.get(0).getIdProvider();
		Provider find = dao.findById(id);
		Assert.assertEquals("Lviv", find.getProviderName());
	}

	@Test
	@Transactional
	public void testFindByName() {
		Provider p = new Provider();
		p.setProviderName("Lviv");
		dao.create(p);
		List<Provider> list = dao.read();
		String name = list.get(0).getProviderName();
		Provider find = dao.findByName(name);
		Assert.assertEquals(p, find);
	}

}

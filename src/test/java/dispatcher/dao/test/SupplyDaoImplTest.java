package dispatcher.dao.test;

import java.time.LocalDate;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import dispatcher.dao.ProviderDaoImpl;
import dispatcher.dao.SupplyDaoImpl;
import dispatcher.entity.Provider;
import dispatcher.entity.Supply;
import dispatcher.exception.DaoException;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SupplyDaoImplTest {

	@Autowired
	private SupplyDaoImpl supplyDao;

	@Autowired
	private ProviderDaoImpl providerDao;

	@Test
	@Transactional
	public void testCreateAndReadSupply() throws DaoException {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Саша", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		List<Supply> supList = supplyDao.read();
		Assert.assertEquals(p.getIdProvider(), supList.get(0).getProvider().getIdProvider());
		Assert.assertEquals(s.getArrivalDate(), supList.get(0).getArrivalDate());
	}

	@Test
	@Transactional
	public void testUpdateSupply() throws DaoException {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Саша", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		s.setCarNumber("AA0001KU");
		supplyDao.update(s);
		List<Supply> supList = supplyDao.read();
		Assert.assertEquals("AA0001KU", supList.get(0).getCarNumber());
	}

	@Test
	@Transactional
	public void testDeleteSupply() throws DaoException {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Саша", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		supplyDao.delete(s.getIdSupply());
		List<Supply> supList = supplyDao.read();
		Assert.assertEquals(0, supList.size());
	}

	@Test
	@Transactional
	public void testFindById() throws DaoException {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Саша", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		List<Supply> supList = supplyDao.read();
		int supId = supList.get(0).getIdSupply();
		Supply sup = supplyDao.findById(supId);
		Assert.assertEquals(s, sup);
	}

	@Test
	@Transactional
	public void testSearchByCriteria() throws DaoException {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Саша", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		Supply s1 = new Supply("AA2834CA", "Александр", "066-469-99-89", "Плитка", "РН5647", "ПЗК-581475", "80",
				LocalDate.now(), "Маша", "Галя", p);
		s.setProvider(p);
		s1.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		supplyDao.create(idProvider, s1);
		List<Supply> search = supplyDao.searchByCriteria("80", "AA2834CA", null, null, idProvider);
		Assert.assertEquals(search.size(), 1);
		Assert.assertEquals(search.get(0).getCarNumber(), "AA2834CA");
		Assert.assertEquals("Киев", search.get(0).getProvider().getProviderName());
	}
}

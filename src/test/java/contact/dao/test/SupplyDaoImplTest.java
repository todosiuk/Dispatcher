package contact.dao.test;

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

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SupplyDaoImplTest {

	@Autowired
	private SupplyDaoImpl supplyDao;

	@Autowired
	private ProviderDaoImpl providerDao;

	@Test
	@Transactional
	public void testCreateAndReadSupply() {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
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
	public void testUpdateSupply() {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
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
	public void testDeleteSupply() {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
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
	public void testFindById() {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
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
	public void testFindByDepartment() {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		List<Supply> supList = supplyDao.findByDepartment(s.getDepartment());
		Assert.assertNotNull(supList);
	}

	@Test
	@Transactional
	public void testFindByCarNumber() {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		List<Supply> supList = supplyDao.findByCarNumber(s.getCarNumber());
		Assert.assertNotNull(supList);
	}

	@Test
	@Transactional
	public void testFindBetweenDate() {
		Provider p = new Provider();
		p.setProviderName("Киев");
		providerDao.create(p);
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80",
				LocalDate.now(), "Вася", "Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		List<Supply> supList = supplyDao.findBetweenDate(LocalDate.now(), LocalDate.now());
		Assert.assertNotNull(supList);
	}

}

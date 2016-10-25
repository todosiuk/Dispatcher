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
		Supply s = new Supply("AA2630CA", "Онашко", "067-569-95-89", "Ламинат", "РН2654", "ПЗК-2655", "80", LocalDate.now(), "Вася",
				"Петя", p);
		s.setProvider(p);
		int idProvider = p.getIdProvider();
		supplyDao.create(idProvider, s);
		List<Supply> supList = supplyDao.read();
		Assert.assertEquals(p.getIdProvider(), supList.get(0).getProvider().getIdProvider());

	}

}

package dispatcher.controller.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import dispatcher.controller.SupplyController;
import dispatcher.dao.ProviderDaoImpl;
import dispatcher.dao.SupplyDaoImpl;
import dispatcher.entity.Provider;
import dispatcher.entity.Supply;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml", "springContextTest.xml" })
public class SupplyControllerTest {

	@InjectMocks
	private SupplyController supplyController;

	private MockMvc mockMvc;

	@Mock
	private SupplyDaoImpl supplyDao;
	@Mock
	private ProviderDaoImpl providerDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(supplyController).build();
	}

	@Test
	public void testShowFormOfAddingSupply() throws Exception {
		Provider provider = new Provider();
		provider.setIdProvider(1);
		provider.setProviderName("OOO");
		Supply supply = new Supply();
		supply.setProvider(provider);

		mockMvc.perform(get("/supplyController/add").param("idProvider", provider.getIdProvider().toString()))
				.andExpect(status().isOk()).andExpect(view().name("formOfAddingSupply"))
				.andExpect(model().attributeExists("supplyAttribute"));

	}

	@Test
	public void testAddingSupply() throws Exception {
		Provider provider = new Provider();
		provider.setIdProvider(1);
		provider.setProviderName("OOO");
		Supply supply = new Supply();
		supply.setProvider(provider);
		supply.setCarNumber("AA2630CA");
		supply.setDepartment("80");
		supply.setDispatcher("Misha");
		supply.setDocumentReceiving("KH1542");
		supply.setDriverName("Pasha");
		supply.setPhone("066-526-56-87");
		supply.setProduct("Ламинат");
		supply.setStorekeeper("Vasya");
		supply.setVendorDocument("KJ5478");

		supplyDao.create(provider.getIdProvider(), supply);

		Mockito.verify(supplyDao).create(provider.getIdProvider(), supply);

		mockMvc.perform(post("/supplyController/add").param("idProvider", provider.getIdProvider().toString()))
				.andExpect(status().isOk()).andExpect(view().name("success"))
				.andExpect(model().attributeExists("supplyAttribute"));
	}
	
	
	
	
}

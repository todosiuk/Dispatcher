package dispatcher.controller.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.Mockito;
import dispatcher.controller.ProviderController;
import dispatcher.dao.ProviderDaoImpl;
import dispatcher.entity.Provider;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml", "springContextTest.xml" })
public class ProviderControllerTest {

	@InjectMocks
	private ProviderController providerController;

	private MockMvc mockMvc;

	@Mock
	private ProviderDaoImpl providerDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(providerController).build();
	}

	@Test
	public void testGetProviders() throws Exception {
		List<Provider> providers = new ArrayList<>();
		providers.add(new Provider());
		providers.add(new Provider());

		when(providerDao.read()).thenReturn(providers);

		mockMvc.perform(get("/providerController/providers")).andExpect(status().isOk())
				.andExpect(view().name("providersList")).andExpect(model().attribute("providers", hasSize(2)));
	}

	@Test
	public void testShowFormOfAddingProvider() throws Exception {
		mockMvc.perform(get("/providerController/providers/add")).andExpect(status().isOk())
				.andExpect(view().name("formOfAddingProvider")).andExpect(model().attributeExists("providerAttribute"));
	}

	@Test
	public void testAddingProvider() throws Exception {
		Provider provider = new Provider();
		provider.setIdProvider(1);
		provider.setProviderName("OOO");
		providerDao.create(provider);

		Mockito.verify(providerDao).create(provider);

		mockMvc.perform(post("/providerController/providers/add")).andExpect(status().isOk())
				.andExpect(view().name("providersList")).andExpect(model().attributeExists("providerAttribute"));
	}

	@Test
	public void testDelete() throws Exception {
		Integer idProvider = 1;
		providerDao.delete(idProvider);

		Mockito.verify(providerDao).delete(idProvider);

		mockMvc.perform(get("/providerController/providers/delete").param("idProvider", idProvider.toString()))
				.andExpect(status().isOk()).andExpect(view().name("providersList"))
				.andExpect(model().attribute("idProvider", idProvider));
	}

	@Test
	public void testShowFormOfUpdatingProvider() throws Exception {
		Integer idProvider = 1;
		mockMvc.perform(get("/providerController/providers/update").param("idProvider", idProvider.toString()))
				.andExpect(status().isOk()).andExpect(view().name("formOfUpdatingProvider"))
				.andExpect(model().attribute("providerAttribute", providerDao.findById(idProvider)));
	}

	@Test
	public void testUpdatingProvider() throws Exception {
		Provider provider = new Provider();
		provider.setIdProvider(1);
		provider.setProviderName("OOO");
		providerDao.create(provider);
		provider.setIdProvider(1);
		provider.setProviderName("AAA");
		providerDao.update(provider);

		Mockito.verify(providerDao).create(provider);
		Mockito.verify(providerDao).update(provider);

		mockMvc.perform(
				post("/providerController/providers/update").param("idProvider", provider.getIdProvider().toString()))
				.andExpect(status().isOk()).andExpect(view().name("providersList"))
				.andExpect(model().attribute("idProvider", provider.getIdProvider()))
				.andExpect(model().attributeExists("providerAttribute"));
	}

	@Test
	public void testSearchProviderByName() throws Exception {
		Provider provider = new Provider();
		provider.setIdProvider(1);
		provider.setProviderName("OOO");
		providerDao.create(provider);
		Provider searchProvider = providerDao.findByName(provider.getProviderName());

		Mockito.verify(providerDao).create(provider);
		Mockito.verify(providerDao).findByName(provider.getProviderName());

		mockMvc.perform(
				get("/providerController/providers/searchByName").param("providerName", provider.getProviderName()))
				.andExpect(status().isOk()).andExpect(view().name("searchProviderByName"))
				.andExpect(model().attribute("provider", searchProvider));
	}

}

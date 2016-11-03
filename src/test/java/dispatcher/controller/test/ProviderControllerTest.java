package dispatcher.controller.test;

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

import dispatcher.controller.ProviderController;
import dispatcher.dao.ProviderDaoImpl;

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
	public void testGetProviders() {

	}

}

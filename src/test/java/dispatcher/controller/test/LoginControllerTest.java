package dispatcher.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import dispatcher.controller.LoginController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml", "springContextTest.xml" })
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("loginForm"));
	}

	@Test
	public void testLoginError() throws Exception {
		mockMvc.perform(get("/denied")).andExpect(status().isOk())
				.andExpect(view().name("deniedPage"));
	}

	@Test
	public void testLogOut() throws Exception {
		mockMvc.perform(get("/logOut")).andExpect(status().isOk()).andExpect(view().name("logOutPage"));
	}

}

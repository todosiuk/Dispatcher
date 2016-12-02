package dispatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home() {
		return "loginForm";
	}

	@RequestMapping(value = "/loginOk", method = RequestMethod.GET)
	public String login() {
		return "providersList";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String loginError() {
		return "deniedPage";
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut() {
		return "logOutPage";
	}

}

package dispatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private final String ERROR_MESSAGE = "Неправильные имя/пароль";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "loginForm";
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", ERROR_MESSAGE);
		return "loginForm";
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut() {
		return "loginForm";
	}

}

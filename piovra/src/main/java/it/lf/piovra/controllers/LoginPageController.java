package it.lf.piovra.controllers;

import it.lf.piovra.controllers.constants.ControllerConstants;
import it.lf.piovra.views.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value= "/login")
public class LoginPageController extends AbstractController
{

	@ModelAttribute(value = "loginForm")
	public LoginForm getLoginForm() {
		return new LoginForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		return ControllerConstants.Views.LOGIN_VIEW;
	}
}

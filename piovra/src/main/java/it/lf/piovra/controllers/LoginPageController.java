package it.lf.piovra.controllers;

import it.lf.piovra.controllers.constants.ControllerConstants;
import it.lf.piovra.views.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value= "/login")
public class LoginPageController extends AbstractController {

    @RequestMapping(method = RequestMethod.GET)
    public String showLogin(Model model) {
        return ControllerConstants.Views.LOGIN_VIEW;
    }

}

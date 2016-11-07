package it.lf.piovra.controllers;

import it.lf.piovra.controllers.constants.ControllerConstants;
import it.lf.piovra.views.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/my-account")
public class MyAccountController extends AbstractController {

    @RequestMapping(value = "/experiments", method = RequestMethod.GET)
    public String showMyAccount(Model model) {
        return ControllerConstants.Views.EXPERIMENTS_VIEW;
    }

}

package it.lf.piovra.controllers;


import it.lf.piovra.views.forms.LoginForm;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class AbstractController {

    protected static final String REDIRECT_PREFIX = "redirect:";

    @ModelAttribute(value = "loginForm")
    public LoginForm getLoginForm() {
        return new LoginForm();
    }

}

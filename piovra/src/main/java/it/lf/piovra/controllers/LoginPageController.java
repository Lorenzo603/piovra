package it.lf.piovra.controllers;

import it.lf.piovra.controllers.constants.ControllerConstants;
import it.lf.piovra.facades.UserFacade;
import it.lf.piovra.facades.data.RegistrationResult;
import it.lf.piovra.facades.data.RegistrationResultStatus;
import it.lf.piovra.views.forms.RegisterForm;
import it.lf.piovra.views.forms.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value= "/login")
public class LoginPageController extends AbstractController {

    @Resource
    private UserFacade userFacade;

    @Autowired
    private PasswordValidator passwordValidator;

    @ModelAttribute(value = "registerForm")
    public RegisterForm getRegisterForm() {
        return new RegisterForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showLogin(Model model) {
        return ControllerConstants.Views.LOGIN_VIEW;
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        passwordValidator.validate(registerForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return ControllerConstants.Views.LOGIN_VIEW;
        }
        RegistrationResult registrationResult = userFacade.registerUser(registerForm.getEmail(), registerForm.getPassword());
        if (!RegistrationResultStatus.OK.equals(registrationResult.getStatus())) {
            bindingResult.reject(registrationResult.getMessageCode());
        }
        return ControllerConstants.Views.LOGIN_VIEW;
    }

}

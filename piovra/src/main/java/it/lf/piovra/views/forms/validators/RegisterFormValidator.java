package it.lf.piovra.views.forms.validators;


import it.lf.piovra.views.forms.RegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegisterFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterForm registerForm = (RegisterForm) o;
        if (!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "register.confirmPassword.different");
        }
    }
}

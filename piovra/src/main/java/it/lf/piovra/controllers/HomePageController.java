package it.lf.piovra.controllers;

import it.lf.piovra.controllers.constants.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomePageController extends AbstractController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        return ControllerConstants.Views.HOMEPAGE_VIEW;
    }

}

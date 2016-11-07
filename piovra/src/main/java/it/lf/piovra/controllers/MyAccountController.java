package it.lf.piovra.controllers;

import it.lf.piovra.controllers.constants.ControllerConstants;
import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.forms.CreateExperimentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/my-account")
public class MyAccountController extends AbstractController {

    @Resource
    private ExperimentFacade experimentFacade;

    @RequestMapping(value = "/experiments", method = RequestMethod.GET)
    public String showMyAccount(Model model) {
        model.addAttribute("createExperimentForm", new CreateExperimentForm());
        model.addAttribute("experiments", experimentFacade.getExperimentsByCurrentUser());
        return ControllerConstants.Views.EXPERIMENTS_VIEW;
    }

    @RequestMapping(value = "/create-experiment", method = RequestMethod.POST)
    public String createExperiment(@Valid CreateExperimentForm createExperimentForm) {
        ExperimentData experimentData = experimentFacade.createExperiment(createExperimentForm.getName());
        return REDIRECT_PREFIX + "/experiments";
    }

}

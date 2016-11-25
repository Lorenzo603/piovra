package it.lf.piovra.controllers;

import it.lf.piovra.controllers.constants.ControllerConstants;
import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.facades.data.CreateExperimentResult;
import it.lf.piovra.facades.data.CreateExperimentStatus;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.forms.CreateExperimentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/my-account")
public class MyAccountController extends AbstractController {

    @Resource
    private ExperimentFacade experimentFacade;

    @ModelAttribute(value = "createExperimentForm")
    public CreateExperimentForm getCreateExperimentForm() {
        return new CreateExperimentForm();
    }

    @ModelAttribute(value = "experiments")
    public List<ExperimentData> getExperimentsForCurrentUser() {
        return experimentFacade.getExperimentsByCurrentUser();
    }

    @RequestMapping(value = "/experiments", method = RequestMethod.GET)
    public String showMyAccount(Model model) {
        return ControllerConstants.Views.EXPERIMENTS_VIEW;
    }

    @RequestMapping(value = "/create-experiment", method = RequestMethod.POST)
    public String createExperiment(@Valid CreateExperimentForm createExperimentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ControllerConstants.Views.EXPERIMENTS_VIEW;
        }
        CreateExperimentResult createExperimentResult = experimentFacade.createExperiment(createExperimentForm.getName());
        if (!CreateExperimentStatus.OK.equals(createExperimentResult.getStatus())) {
            bindingResult.rejectValue("name", createExperimentResult.getMessageCode());
            return ControllerConstants.Views.EXPERIMENTS_VIEW;
        }
        return REDIRECT_PREFIX + "/my-account/experiment/" + createExperimentResult.getCreatedExperiment().getName();
    }



}

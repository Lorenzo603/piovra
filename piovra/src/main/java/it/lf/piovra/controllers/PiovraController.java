package it.lf.piovra.controllers;

import com.google.gson.Gson;
import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.facades.LevelFacade;
import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.FactorData;
import it.lf.piovra.views.LevelData;
import it.lf.piovra.views.SuiteData;
import it.lf.piovra.views.forms.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Lfurrer on 28/04/2016.
 */
@Controller
@RequestMapping("/")
public class PiovraController {

    private static final Logger LOG = LogManager.getLogger(PiovraController.class);

    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String HOMEPAGE_VIEW = "index";
    private static final String CALCULATE_RESULT_VIEW = "calculateResult";

    @Resource
    private SuiteFacade suiteFacade;

    @Resource
    private ExperimentFacade experimentFacade;

    @Resource
    private FactorFacade factorFacade;

    @Resource
    private LevelFacade levelFacade;

    @Resource
    private Gson gsonUtils;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        addModelAttributes(model);
        return HOMEPAGE_VIEW;
    }

    protected void addModelAttributes(Model model) {
        ExperimentData experimentData = experimentFacade.getExperiment();
        model.addAttribute("experiment", experimentData);

        model.addAttribute("addFactorForm", new AddFactorForm());

        List<FactorData> factors = experimentData.getFactors();
        for (FactorData factorData : factors) {
            String factorId = factorData.getId();
            addEditFactorFormModelAttribute(model, factorId);
            addRemoveFactorFormModelAttribute(model, factorId);

            for (LevelData levelData : factorData.getLevels()) {
                String levelId = levelData.getId();
                addEditLevelFormModelAttribute(model, levelId);
                addRemoveLevelFormModelAttribute(model, levelId);
            }

            addAddLevelFormModelAttribute(model, factorId);
        }
    }

    protected void addEditFactorFormModelAttribute(Model model, String factorId) {
        EditFactorForm editFactorForm = new EditFactorForm();
        editFactorForm.setId(factorId);
        model.addAttribute("editFactorForm-" + factorId, editFactorForm);
    }

    protected void addRemoveFactorFormModelAttribute(Model model, String factorId) {
        RemoveFactorForm removeFactorForm = new RemoveFactorForm();
        removeFactorForm.setId(factorId);
        model.addAttribute("removeFactorForm-" + factorId, removeFactorForm);
    }

    protected void addAddLevelFormModelAttribute(Model model, String factorId) {
        AddLevelForm addLevelForm = new AddLevelForm();
        addLevelForm.setFactorId(factorId);
        model.addAttribute("addLevelForm-" + factorId, addLevelForm);
    }

    protected void addEditLevelFormModelAttribute(Model model, String levelId) {
        EditLevelForm editLevelForm = new EditLevelForm();
        editLevelForm.setId(levelId);
        model.addAttribute("editLevelForm-" + levelId, editLevelForm);
    }

    protected void addRemoveLevelFormModelAttribute(Model model, String levelId) {
        RemoveLevelForm removeLevelForm = new RemoveLevelForm();
        removeLevelForm.setId(levelId);
        model.addAttribute("removeLevelForm-" + levelId, removeLevelForm);
    }

    @ResponseBody
    @RequestMapping(value = "/getExperiment", method = RequestMethod.GET, produces = "application/json")
    public String getExperiment() {
        ExperimentData experimentData = experimentFacade.getExperiment();
        return gsonUtils.toJson(experimentData);
    }

    @RequestMapping(value = "/add-factor", method = RequestMethod.POST, produces = "application/json")
    public String addFactor(@Valid AddFactorForm addFactorForm) {
        factorFacade.addFactor(addFactorForm.getName());
        return REDIRECT_PREFIX + "/";
    }

    @ResponseBody
    @RequestMapping(value = "/edit-factor", method = RequestMethod.POST, produces = "application/json")
    }

    @ResponseBody
    @RequestMapping(value = "/remove-factor", method = RequestMethod.POST)
    }

    @RequestMapping(value = "/add-level", method = RequestMethod.POST)
        levelFacade.addLevel(addLevelForm.getName(), addLevelForm.getFactorId());
        return REDIRECT_PREFIX + "/";
    }

    @ResponseBody
    @RequestMapping(value = "/edit-level", method = RequestMethod.POST)
    }

    @ResponseBody
    @RequestMapping(value = "/remove-level", method = RequestMethod.POST)
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(Model model) {
        SuiteData suiteData = suiteFacade.calculate();
        model.addAttribute("suite", suiteData);
        return CALCULATE_RESULT_VIEW;
    }

}

package it.lf.piovra.controllers;

import com.google.gson.Gson;
import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.facades.LevelFacade;
import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.FactorData;
import it.lf.piovra.views.LevelData;
import it.lf.piovra.views.SuiteData;
import it.lf.piovra.views.forms.AddFactorForm;
import it.lf.piovra.views.forms.AddLevelForm;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute("addFactorForm")
    public AddFactorForm getAddFactorForm() {
        return new AddFactorForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        addModelAttributes(model);
        return HOMEPAGE_VIEW;
    }

    protected void addModelAttributes(Model model) {
        ExperimentData experimentData = experimentFacade.getExperiment();
        model.addAttribute("experiment", experimentData);

        List<FactorData> factors = experimentData.getFactors();
        for (FactorData factorData : factors) {
            AddLevelForm addLevelForm = new AddLevelForm();
            String factorId = factorData.getId();
            addLevelForm.setFactorId(factorId);
            model.addAttribute("addLevelForm-" + factorId, addLevelForm);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getExperiment", method = RequestMethod.GET, produces = "application/json")
    public String getExperiment() {
        ExperimentData experimentData = experimentFacade.getExperiment();
        return gsonUtils.toJson(experimentData);
    }

    @RequestMapping(value = "/add-factor", method = RequestMethod.POST, produces = "application/json")
    public String addFactor(@Valid AddFactorForm addFactorForm, Model model) {
        factorFacade.addFactor(addFactorForm.getName());
        return REDIRECT_PREFIX + "/";
    }

    @ResponseBody
    @RequestMapping(value = "/edit-factor", method = RequestMethod.POST, produces = "application/json")
    public String editFactor(@RequestParam String id, @RequestParam String factorName) {
        FactorData factorData = factorFacade.editFactor(id, factorName);
        return gsonUtils.toJson(factorData);
    }

    @ResponseBody
    @RequestMapping(value = "/remove-factor", method = RequestMethod.POST)
    public String removeFactor(@RequestParam String id) {
        factorFacade.removeFactor(id);
        return "OK";
    }

    @RequestMapping(value = "/add-level", method = RequestMethod.POST)
    public String addLevel(@Valid AddLevelForm addLevelForm, Model model) {
        levelFacade.addLevel(addLevelForm.getName(), addLevelForm.getFactorId());
        return REDIRECT_PREFIX + "/";
    }

    @ResponseBody
    @RequestMapping(value = "/edit-level", method = RequestMethod.POST)
    public String editLevel(@RequestParam String id, @RequestParam String levelName) {
        LevelData levelData = levelFacade.editLevel(id, levelName);
        return gsonUtils.toJson(levelData);
    }

    @ResponseBody
    @RequestMapping(value = "/remove-level", method = RequestMethod.POST)
    public String removeLevel(@RequestParam String id) {
        levelFacade.removeLevel(id);
        return "OK";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(Model model) {
        SuiteData suiteData = suiteFacade.calculate();
        model.addAttribute("suite", suiteData);
        return CALCULATE_RESULT_VIEW;
    }

}

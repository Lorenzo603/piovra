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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Lfurrer on 28/04/2016.
 */
@Controller
@RequestMapping("/")
public class PiovraController {

    private static final Logger LOG = LogManager.getLogger(PiovraController.class);

    private static final String HOMEPAGE_VIEW = "index";

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
    public String showHome() {

        LOG.info(suiteFacade.getString());

        return HOMEPAGE_VIEW;
    }

    @ResponseBody
    @RequestMapping(value = "/getExperiment", method = RequestMethod.GET, produces = "application/json")
    public String getExperiment() {
        ExperimentData experimentData = experimentFacade.getExperiment();
        return gsonUtils.toJson(experimentData);
    }

    @ResponseBody
    @RequestMapping(value = "/add-factor", method = RequestMethod.POST, produces = "application/json")
    public String addFactor(@RequestParam String factorName) {
        FactorData factorData = factorFacade.addFactor(factorName);
        return gsonUtils.toJson(factorData);
    }

    @ResponseBody
    @RequestMapping(value = "/edit-factor", method = RequestMethod.POST, produces = "application/json")
    public String editFactor(@RequestParam String id, @RequestParam String factorName) {
        FactorData factorData = factorFacade.editFactor(id, factorName);
        return gsonUtils.toJson(factorData);
    }

    @ResponseBody
    @RequestMapping(value = "/add-level", method = RequestMethod.POST)
    public String addLevel(@RequestParam String levelName, @RequestParam String factorId) {
        LevelData levelData = levelFacade.addLevel(levelName, factorId);
        return gsonUtils.toJson(levelData);
    }

    @ResponseBody
    @RequestMapping(value = "/edit-level", method = RequestMethod.POST)
    public String editLevel(@RequestParam String id, @RequestParam String levelName) {
        LevelData levelData = levelFacade.editLevel(id, levelName);
        return gsonUtils.toJson(levelData);
    }

}

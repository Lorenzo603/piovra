package it.lf.piovra.controllers;

import com.google.gson.Gson;
import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.views.FactorData;
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
    private FactorFacade factorFacade;

    @Resource
    private Gson gsonUtils;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {

        LOG.info(suiteFacade.getString());

        return HOMEPAGE_VIEW;
    }

    @ResponseBody
    @RequestMapping(value = "/save-factor", method = RequestMethod.POST, produces = "application/json")
    public String addFactor(@RequestParam String factorName) {
        FactorData factorData = factorFacade.createFactor(factorName);
        return gsonUtils.toJson(factorData);
    }

    @ResponseBody
    @RequestMapping(value = "/save-level", method = RequestMethod.POST)
    public String addLevel(@RequestParam String levelName) {

        return "";
    }

}

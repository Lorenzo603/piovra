package it.lf.piovra.controllers;

import it.lf.piovra.facades.SuiteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {

        LOG.info(suiteFacade.getString());

        return HOMEPAGE_VIEW;
    }

}

package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.scala.core.SuiteCalculator;
import it.lf.piovra.services.SuiteService;

import java.util.List;

/**
 * Created by Lorenzo on 17/05/2016.
 */
public class SuiteServiceImpl implements SuiteService {

    @Override
    public List<List<String>> calculate(Experiment experiment) {
        return new SuiteCalculator().calculate();
    }
}

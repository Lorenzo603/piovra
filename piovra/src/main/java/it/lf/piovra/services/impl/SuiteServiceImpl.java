package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.models.Level;
import it.lf.piovra.scala.core.SuiteCalculator;
import it.lf.piovra.services.SuiteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lorenzo on 17/05/2016.
 */
public class SuiteServiceImpl implements SuiteService {

    @Override
    public List<List<String>> calculate(Experiment experiment) {
        // TODO
        Map<String, List<String>> map = new HashMap<>();
        for (Factor factor : experiment.getFactors()) {
            List<String> levelNames = new ArrayList<>();
            for (Level level : factor.getLevels()) {
                levelNames.add(level.getName());
            }
            map.put(factor.getName(), levelNames);
        }

        return new SuiteCalculator().calculate(map);
    }
}

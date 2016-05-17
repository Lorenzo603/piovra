package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;

import java.util.List;

/**
 * Created by Lorenzo on 17/05/2016.
 */
public interface SuiteService {

    List<List<String>> calculate(Experiment experiment);

}

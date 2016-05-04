package it.lf.piovra.services;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.FactorData;

/**
 * Created by Lfurrer on 04/05/2016.
 */
public interface ExperimentConverter {

    ExperimentData convert(Experiment source);

    ExperimentData convert(Experiment source, ExperimentData target);

}

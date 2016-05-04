package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.services.ExperimentConverter;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.FactorData;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lfurrer on 04/05/2016.
 */
public class ExperimentConverterImpl implements ExperimentConverter {

    private FactorConverter factorConverter;

    @Override
    public ExperimentData convert(Experiment source) {
        return convert(source, new ExperimentData());
    }

    @Override
    public ExperimentData convert(Experiment source, ExperimentData target) {
        List<FactorData> factors = new ArrayList<>();
        for (Factor factor : source.getFactors()) {
            factors.add(factorConverter.convert(factor));
        }
        target.setFactors(factors);
        return target;
    }

    @Required
    public void setFactorConverter(FactorConverter factorConverter) {
        this.factorConverter = factorConverter;
    }
}

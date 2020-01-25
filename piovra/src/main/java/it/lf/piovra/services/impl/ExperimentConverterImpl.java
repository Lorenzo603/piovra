package it.lf.piovra.services.impl;

import it.lf.piovra.models.Experiment;
import it.lf.piovra.models.Factor;
import it.lf.piovra.services.ExperimentConverter;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.FactorData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExperimentConverterImpl implements ExperimentConverter {

    @Resource
    private FactorConverter factorConverter;

    @Override
    public ExperimentData convert(Experiment source) {
        return convert(source, new ExperimentData());
    }

    @Override
    public ExperimentData convert(Experiment source, ExperimentData target) {
        target.setId(source.getId());
        target.setName(source.getName());
        List<FactorData> factors = new ArrayList<>();
        for (Factor factor : source.getFactors()) {
            factors.add(factorConverter.convert(factor));
        }
        target.setFactors(factors);
        target.setTimeCreated(source.getTimeCreated());
        return target;
    }

}

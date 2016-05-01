package it.lf.piovra.services.impl;

import it.lf.piovra.models.Factor;
import it.lf.piovra.services.FactorConverter;
import it.lf.piovra.views.FactorData;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public class FactorConverterImpl implements FactorConverter {

    @Override
    public FactorData convert(Factor source) {
       return convert(source, new FactorData());
    }

    @Override
    public FactorData convert(Factor source, FactorData target) {
        target.setName(source.getName());
        return target;
    }


}

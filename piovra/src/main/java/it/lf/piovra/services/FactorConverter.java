package it.lf.piovra.services;

import it.lf.piovra.models.Factor;
import it.lf.piovra.views.FactorData;

/**
 * Created by Lfurrer on 01/05/2016.
 */
public interface FactorConverter {

    FactorData convert(Factor source);

    FactorData convert(Factor source, FactorData target);

}

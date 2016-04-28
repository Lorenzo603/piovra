package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.scala.core.SuiteCalculator;

/**
 * Created by Lfurrer on 28/04/2016.
 */
public class SuiteFacadeImpl implements SuiteFacade {


    @Override
    public String getString() {
        return new SuiteCalculator().calculate();
    }
}

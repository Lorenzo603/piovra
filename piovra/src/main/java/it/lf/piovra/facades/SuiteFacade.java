package it.lf.piovra.facades;

import it.lf.piovra.views.SuiteData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Created by Lfurrer on 28/04/2016.
 */
public interface SuiteFacade {

    SuiteData calculate();

    HSSFWorkbook generateExcelFile();

}

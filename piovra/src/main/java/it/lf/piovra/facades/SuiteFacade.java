package it.lf.piovra.facades;

import it.lf.piovra.views.SuiteData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public interface SuiteFacade {

    SuiteData calculate(String experimentId);

    HSSFWorkbook generateExcelFile(String experimentId);

}

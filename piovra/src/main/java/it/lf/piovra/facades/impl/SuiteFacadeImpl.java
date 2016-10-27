package it.lf.piovra.facades.impl;

import it.lf.piovra.controllers.PiovraController;
import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.SuiteService;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.SuiteData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Required;

import java.io.IOException;
import java.util.List;

/**
 * Created by Lfurrer on 28/04/2016.
 */
public class SuiteFacadeImpl implements SuiteFacade {


    private SuiteService suiteService;

    private ExperimentService experimentService;

    @Override
    public SuiteData calculate() {
        SuiteData suiteData = new SuiteData();
        List<List<String>> results = suiteService.calculate(experimentService.getExperiment());
        suiteData.setCases(results);
        return suiteData;
    }

    @Required
    public void setSuiteService(SuiteService suiteService) {
        this.suiteService = suiteService;
    }

    @Required
    public void setExperimentService(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @Override
    public HSSFWorkbook generateExcelFile() {
        SuiteData suiteData = calculate();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Experiment");

        int rowCount = 0;
        int colCount = 0;
        for (List<String> suiteCase : suiteData.getCases()) {
            Row row = sheet.createRow(rowCount++);
            for (String level : suiteCase ) {
                Cell cell = row.createCell(colCount++);
                cell.setCellValue(level);
            }
            colCount = 0;
        }
        return workbook;

    }
}

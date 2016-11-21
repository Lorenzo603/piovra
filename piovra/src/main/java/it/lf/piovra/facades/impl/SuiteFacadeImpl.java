package it.lf.piovra.facades.impl;

import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.models.Experiment;
import it.lf.piovra.services.ExperimentService;
import it.lf.piovra.services.SuiteService;
import it.lf.piovra.views.SuiteData;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SuiteFacadeImpl implements SuiteFacade {

    @Resource
    private SuiteService suiteService;
    @Resource
    private ExperimentService experimentService;

    @Override
    public SuiteData calculate(String experimentId) {
        SuiteData suiteData = new SuiteData();
        suiteData.setExperimentId(experimentId);
        Experiment experiment = experimentService.getExperimentById(experimentId);
        suiteData.setFactorNames(experiment.getFactors().stream().map(factor -> factor.getName()).collect(Collectors.toList()));
        List<List<String>> results = suiteService.calculate(experiment);
        suiteData.setCases(results);
        return suiteData;
    }

    @Override
    public HSSFWorkbook generateExcelFile(String experimentId) {
        SuiteData suiteData = calculate(experimentId);

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

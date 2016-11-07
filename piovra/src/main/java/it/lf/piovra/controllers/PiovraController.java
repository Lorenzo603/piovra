package it.lf.piovra.controllers;

import com.google.gson.Gson;
import it.lf.piovra.controllers.constants.ControllerConstants;
import it.lf.piovra.facades.ExperimentFacade;
import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.facades.LevelFacade;
import it.lf.piovra.facades.SuiteFacade;
import it.lf.piovra.views.ExperimentData;
import it.lf.piovra.views.FactorData;
import it.lf.piovra.views.LevelData;
import it.lf.piovra.views.SuiteData;
import it.lf.piovra.views.forms.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class PiovraController extends AbstractController {

    private static final Logger LOG = LogManager.getLogger(PiovraController.class);

    @Resource
    private SuiteFacade suiteFacade;

    @Resource
    private ExperimentFacade experimentFacade;

    @Resource
    private FactorFacade factorFacade;

    @Resource
    private LevelFacade levelFacade;

    @Resource
    private Gson gsonUtils;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        addModelAttributes(model);
        return ControllerConstants.Views.HOMEPAGE_VIEW;
    }

    protected void addModelAttributes(Model model) {
        ExperimentData experimentData = experimentFacade.getExperiment();
        model.addAttribute("experiment", experimentData);

        model.addAttribute("addFactorForm", new AddFactorForm());

        List<FactorData> factors = experimentData.getFactors();
        for (FactorData factorData : factors) {
            String factorId = factorData.getId();
            addEditFactorFormModelAttribute(model, factorId);
            addRemoveFactorFormModelAttribute(model, factorId);

            for (LevelData levelData : factorData.getLevels()) {
                String levelId = levelData.getId();
                addEditLevelFormModelAttribute(model, levelId);
                addRemoveLevelFormModelAttribute(model, levelId);
            }

            addAddLevelFormModelAttribute(model, factorId);
        }
    }

    protected void addEditFactorFormModelAttribute(Model model, String factorId) {
        EditFactorForm editFactorForm = new EditFactorForm();
        editFactorForm.setId(factorId);
        model.addAttribute("editFactorForm-" + factorId, editFactorForm);
    }

    protected void addRemoveFactorFormModelAttribute(Model model, String factorId) {
        RemoveFactorForm removeFactorForm = new RemoveFactorForm();
        removeFactorForm.setId(factorId);
        model.addAttribute("removeFactorForm-" + factorId, removeFactorForm);
    }

    protected void addAddLevelFormModelAttribute(Model model, String factorId) {
        AddLevelForm addLevelForm = new AddLevelForm();
        addLevelForm.setFactorId(factorId);
        model.addAttribute("addLevelForm-" + factorId, addLevelForm);
    }

    protected void addEditLevelFormModelAttribute(Model model, String levelId) {
        EditLevelForm editLevelForm = new EditLevelForm();
        editLevelForm.setId(levelId);
        model.addAttribute("editLevelForm-" + levelId, editLevelForm);
    }

    protected void addRemoveLevelFormModelAttribute(Model model, String levelId) {
        RemoveLevelForm removeLevelForm = new RemoveLevelForm();
        removeLevelForm.setId(levelId);
        model.addAttribute("removeLevelForm-" + levelId, removeLevelForm);
    }

    @ResponseBody
    @RequestMapping(value = "/getExperiment", method = RequestMethod.GET, produces = "application/json")
    public String getExperiment() {
        ExperimentData experimentData = experimentFacade.getExperiment();
        return gsonUtils.toJson(experimentData);
    }

    @RequestMapping(value = "/add-factor", method = RequestMethod.POST, produces = "application/json")
    public String addFactor(@Valid AddFactorForm addFactorForm) {
        factorFacade.addFactor(addFactorForm.getName());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/edit-factor", method = RequestMethod.POST, produces = "application/json")
    public String editFactor(@Valid EditFactorForm editFactorForm) {
        factorFacade.editFactor(editFactorForm.getId(), editFactorForm.getNewName());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/remove-factor", method = RequestMethod.POST)
    public String removeFactor(@Valid RemoveFactorForm removeFactorForm) {
        factorFacade.removeFactor(removeFactorForm.getId());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/add-level", method = RequestMethod.POST)
    public String addLevel(@Valid AddLevelForm addLevelForm) {
        levelFacade.addLevel(addLevelForm.getName(), addLevelForm.getFactorId());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/edit-level", method = RequestMethod.POST)
    public String editLevel(@Valid EditLevelForm editLevelForm) {
        levelFacade.editLevel(editLevelForm.getId(), editLevelForm.getNewName());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/remove-level", method = RequestMethod.POST)
    public String removeLevel(@Valid RemoveLevelForm removeLevelForm) {
        levelFacade.removeLevel(removeLevelForm.getId());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(Model model) {
        SuiteData suiteData = suiteFacade.calculate();
        model.addAttribute("suite", suiteData);
        return ControllerConstants.Views.CALCULATE_RESULT_VIEW;
    }

    @RequestMapping(value = "/export-to-excel", method = RequestMethod.GET)
    public void exportToExcel(HttpServletResponse response) {
        HSSFWorkbook excelFile = suiteFacade.generateExcelFile();
        try {
            excelFile.write(response.getOutputStream());
            response.setHeader("Content-disposition", "attachment; filename=" + "experiment.xls");
            response.setContentType("application/vnd.ms-excel");
            response.flushBuffer();
        } catch (IOException ioe) {
            LOG.error("Error while sending generated Excel file", ioe);
        }
    }

}

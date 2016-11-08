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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/my-account")
public class MyAccountController extends AbstractController {

    private static final Logger LOG = LogManager.getLogger(MyAccountController.class);

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

    @RequestMapping(value = "/experiments", method = RequestMethod.GET)
    public String showMyAccount(Model model) {
        model.addAttribute("createExperimentForm", new CreateExperimentForm());
        model.addAttribute("experiments", experimentFacade.getExperimentsByCurrentUser());
        return ControllerConstants.Views.EXPERIMENTS_VIEW;
    }

    @RequestMapping(value = "/create-experiment", method = RequestMethod.POST)
    public String createExperiment(@Valid CreateExperimentForm createExperimentForm) {
        ExperimentData experimentData = experimentFacade.createExperiment(createExperimentForm.getName());
        return REDIRECT_PREFIX + "/my-account/experiment/" + experimentData.getName();
    }

    @RequestMapping(value = "/experiment/{experimentId}", method = RequestMethod.GET)
    public String showExperiment(@PathVariable("experimentId") String experimentId, Model model) {
        addModelAttributes(model, experimentId);
        return ControllerConstants.Views.EXPERIMENT_VIEW;
    }

    protected void addModelAttributes(Model model, String experimentId) {
        ExperimentData experimentData = experimentFacade.getExperimentById(experimentId);
        model.addAttribute("experiment", experimentData);

        AddFactorForm addFactorForm = new AddFactorForm();
        addFactorForm.setExperimentId(experimentId);
        model.addAttribute("addFactorForm", addFactorForm);

        List<FactorData> factors = experimentData.getFactors();
        for (FactorData factorData : factors) {
            String factorId = factorData.getId();
            addEditFactorFormModelAttribute(model, factorId, experimentId);
            addRemoveFactorFormModelAttribute(model, factorId, experimentId);

            for (LevelData levelData : factorData.getLevels()) {
                String levelId = levelData.getId();
                addEditLevelFormModelAttribute(model, levelId, factorId, experimentId );
                addRemoveLevelFormModelAttribute(model, levelId, factorId, experimentId);
            }

            addAddLevelFormModelAttribute(model, factorId, experimentId);
        }

        CalculateExperimentForm calculateExperimentForm = new CalculateExperimentForm();
        calculateExperimentForm.setExperimentId(experimentId);
        model.addAttribute("calculateForm", calculateExperimentForm);
    }

    protected void addEditFactorFormModelAttribute(Model model, String factorId, String experimentId) {
        EditFactorForm editFactorForm = new EditFactorForm();
        editFactorForm.setExperimentId(experimentId);
        editFactorForm.setId(factorId);
        model.addAttribute("editFactorForm-" + factorId, editFactorForm);
    }

    protected void addRemoveFactorFormModelAttribute(Model model, String factorId, String experimentId) {
        RemoveFactorForm removeFactorForm = new RemoveFactorForm();
        removeFactorForm.setExperimentId(experimentId);
        removeFactorForm.setId(factorId);
        model.addAttribute("removeFactorForm-" + factorId, removeFactorForm);
    }

    protected void addAddLevelFormModelAttribute(Model model, String factorId, String experimentId) {
        AddLevelForm addLevelForm = new AddLevelForm();
        addLevelForm.setExperimentId(experimentId);
        addLevelForm.setFactorId(factorId);
        model.addAttribute("addLevelForm-" + factorId, addLevelForm);
    }

    protected void addEditLevelFormModelAttribute(Model model, String levelId, String factorId, String experimentId) {
        EditLevelForm editLevelForm = new EditLevelForm();
        editLevelForm.setExperimentId(experimentId);
        editLevelForm.setFactorId(factorId);
        editLevelForm.setId(levelId);
        model.addAttribute("editLevelForm-" + levelId, editLevelForm);
    }

    protected void addRemoveLevelFormModelAttribute(Model model, String levelId, String factorId, String experimentId) {
        RemoveLevelForm removeLevelForm = new RemoveLevelForm();
        removeLevelForm.setExperimentId(experimentId);
        removeLevelForm.setFactorId(factorId);
        removeLevelForm.setId(levelId);
        model.addAttribute("removeLevelForm-" + levelId, removeLevelForm);
    }

    @ResponseBody
    @RequestMapping(value = "/getExperiment", method = RequestMethod.GET, produces = "application/json")
    public String getExperiment() {
        ExperimentData experimentData = experimentFacade.getExperimentById("non existing id");
        return gsonUtils.toJson(experimentData);
    }

    @RequestMapping(value = "/add-factor", method = RequestMethod.POST, produces = "application/json")
    public String addFactor(@Valid AddFactorForm addFactorForm) {
        factorFacade.addFactor(addFactorForm.getExperimentId(), addFactorForm.getName());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/edit-factor", method = RequestMethod.POST, produces = "application/json")
    public String editFactor(@Valid EditFactorForm editFactorForm) {
        factorFacade.editFactor(editFactorForm.getExperimentId(), editFactorForm.getId(), editFactorForm.getNewName());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/remove-factor", method = RequestMethod.POST)
    public String removeFactor(@Valid RemoveFactorForm removeFactorForm) {
        factorFacade.removeFactor(removeFactorForm.getExperimentId(), removeFactorForm.getId());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/add-level", method = RequestMethod.POST)
    public String addLevel(@Valid AddLevelForm addLevelForm) {
        levelFacade.addLevel(addLevelForm.getExperimentId(), addLevelForm.getFactorId(), addLevelForm.getName());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/edit-level", method = RequestMethod.POST)
    public String editLevel(@Valid EditLevelForm editLevelForm) {
        levelFacade.editLevel(editLevelForm.getExperimentId(), editLevelForm.getFactorId(), editLevelForm.getId(), editLevelForm.getNewName());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/remove-level", method = RequestMethod.POST)
    public String removeLevel(@Valid RemoveLevelForm removeLevelForm) {
        levelFacade.removeLevel(removeLevelForm.getExperimentId(), removeLevelForm.getFactorId(), removeLevelForm.getId());
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(@Valid CalculateExperimentForm calculateExperimentForm, Model model) {
        SuiteData suiteData = suiteFacade.calculate(calculateExperimentForm.getExperimentId());
        model.addAttribute("suite", suiteData);
        return ControllerConstants.Views.CALCULATE_RESULT_VIEW;
    }

    @RequestMapping(value = "/export-to-excel", method = RequestMethod.GET)
    public void exportToExcel(@Valid GenerateExcelForm generateExcelForm, HttpServletResponse response) {
        HSSFWorkbook excelFile = suiteFacade.generateExcelFile(generateExcelForm.getExperimentId());
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

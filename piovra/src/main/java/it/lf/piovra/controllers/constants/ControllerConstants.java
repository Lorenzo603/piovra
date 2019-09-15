package it.lf.piovra.controllers.constants;

public interface ControllerConstants {

    interface Controllers {
        String LOGIN = "/login";
        String MY_ACCOUNT = "/my-account";
        String EXPERIMENT = "/my-account/experiment";
    }

    interface Views {
        String HOMEPAGE_VIEW = "index";
        String REGISTER_VIEW = "register";

        String EXPERIMENTS_VIEW = "experiments";
        String EXPERIMENT_VIEW = "experiment";
        String CALCULATE_RESULT_VIEW = "calculateResult";
    }

}

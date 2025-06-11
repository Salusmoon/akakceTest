package stepDefinitions;

import io.cucumber.java.en.When;
import steps.LoginSteps;

public class LoginStepDef {

    LoginSteps loginSteps = new LoginSteps();


    @When("Click continues without login")
    public void userContinuesWithoutLogin() {
        loginSteps.continuesWithoutLogin();
    }

}

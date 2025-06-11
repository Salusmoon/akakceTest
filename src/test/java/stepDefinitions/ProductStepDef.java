package stepDefinitions;

import io.cucumber.java.en.Then;
import steps.ProductSteps;


public class ProductStepDef {

    ProductSteps productSteps = new ProductSteps();

    @Then("User check buton Satıcıya Git")
    public void userCheckButonSatıcıyaGit() {
        productSteps.checkbtnGoToSeller();
    }
}

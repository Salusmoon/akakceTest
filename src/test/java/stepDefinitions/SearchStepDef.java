package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import steps.SearchSteps;


public class SearchStepDef {

    SearchSteps searchSteps = new SearchSteps();

    @And("Set {string} in search bar")
    public void setInSearchBar(String product) throws InterruptedException {
        searchSteps.searchProduct(product);
    }

    @And("User applies filters on product list")
    public void userAppliesFiltersOnProductList() {
        searchSteps.clickAndSetFilter();
    }

    @And("User list most expensive products")
    public void userListMostExpensiveProducts() {
        searchSteps.listMostExpensiveProducts();
    }

    @And("User select the {string} product")
    public void userSelectTheProduct(String index) {
        searchSteps.clickItemForProductList(index);
    }


}

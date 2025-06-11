package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Locater.SearchLocater.*;

public class SearchSteps extends BaseSteps{

    private static final Logger logger = LogManager.getLogger(BaseSteps.class);


    public void searchProduct(String product) throws InterruptedException {
        clickElement(searchBar);
        sendKeys(searchInputXpath,product);
        sendEnter();
    }

    public void clickAndSetFilter() {
        if(!isDisplayed(txtTitleProductList)){
            sendEnter();
        }
        swipeUntilElementVisible(btnFilter,5);
        clickElement(btnFilter);
        clickElement(btnListProducts);
    }

    public void listMostExpensiveProducts() {
        clickElement(btnSort);
        clickElement(listMostPrice);
    }

    public void clickItemForProductList(String index) {
        List<WebElement> listProductElementName = findElements(txtProductName);
        List<String> listProductName = new java.util.ArrayList<>(List.of());
        for (WebElement webElement : listProductElementName) {
            listProductName.add(webElement.getText());
        }
        int index2 = Integer.parseInt(index);
        while (listProductName.size() < index2) {
            swipeforElements(areaProduct, 1);
            List<WebElement> productsAfterSwipe = findElements(txtProductName);

            if (!productsAfterSwipe.isEmpty()) {
                String lastProductName = productsAfterSwipe.get(productsAfterSwipe.size() - 1).getText();

                if (!listProductName.contains(lastProductName)) {
                    listProductName.add(lastProductName);
                    logger.info("Adding to product list. list size {}. ", listProductName.size());
                    logger.info("model name {}", lastProductName);
                }
            }
        }
        clickElementOnListBack(areaProduct,1);
        swipeUntilElementVisible(btnGoToProduct,5);
        clickElement(btnGoToProduct);
    }

}

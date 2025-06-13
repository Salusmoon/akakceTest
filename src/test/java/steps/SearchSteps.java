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
        clickElement(searchInputXpath);
        sendKeys(searchInputXpath,product);
        clickElement(searchInputXpath);
        sendEnter();
    }

    public void clickAndSetFilter() {
        while (!isDisplayed(txtTitleProductList)){
            clickElement(searchInputXpath);
            sendEnter();
        }
        swipeUntilElementVisible(btnFilter,5);
        clickElement(btnFilter);
        swipeUntilElementVisible(btn4KFilter,10);
        clickElement(btn4KFilter);
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
                for (WebElement product : productsAfterSwipe) {
                    String productName = product.getText().trim();

                    if (!listProductName.contains(productName)) {
                        listProductName.add(productName);
                        logger.info("Product added to list. Current list size: {}", listProductName.size());
                        logger.info("Added product name: {}", productName);
                    } else {
                        logger.debug("Duplicate product skipped: {}", productName);
                    }
                }
            }
        }
        clickElement(getProductByName(listProductName.get(index2-1)));
        swipeUntilElementVisible(btnGoToProduct, 5);
        clickElement(btnGoToProduct);
    }
}

package Locater;

import org.openqa.selenium.By;

public class SearchLocater {

    public static final By searchBar=By.id("com.akakce.akakce:id/searchTextView");
    public static final By searchInputXpath=By.xpath("(//android.widget.EditText[@resource-id=\"com.akakce.akakce:id/searchTextView\"])[2]");
    public static final By btnFilter= By.id("com.akakce.akakce:id/filterArea");
    public static final By btnListProducts= By.id("com.akakce.akakce:id/apply");
    public static final By btnSort= By.id("com.akakce.akakce:id/sortArea");
    public static final By listMostPrice= By.xpath("//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/sort_name\" and @text=\"En Yüksek Fiyat\"]");
    public static final By areaProduct = By.id("com.akakce.akakce:id/card");
    public static final By txtTitleProductList= By.id("com.akakce.akakce:id/campaignTitle");
    public static final By txtProductName= By.id("com.akakce.akakce:id/name");
    public static final By btnGoToProduct = By.id("com.akakce.akakce:id/detailBtnLayout");
    public static final By btn4KFilter = By.xpath("//android.widget.TextView[@text=\"4K\"]");
}

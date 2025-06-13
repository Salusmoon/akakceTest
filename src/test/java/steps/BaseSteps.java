package steps;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BaseSteps {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait wait;
    protected WebElement element;

    private static final Logger logger = LogManager.getLogger(BaseSteps.class);


    public BaseSteps() {
        this.appiumDriver = BaseTest.driver;
    }


    public WebElement findElement(By by) {
        wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public List<WebElement> findElements(By by) {
        return appiumDriver.findElements(by);
    }


    public void clickElement(By by) {
        try {
            logger.debug("Trying to find and click element: {}", by);
            WebElement element = findElement(by);
            element.click();
            logger.info("Clicked on element: {}", by);
        } catch (TimeoutException e) {
            logger.warn("Timeout while waiting for element to be clickable: {}", by);
        } catch (Exception e) {
            logger.error("Unexpected error while clicking element: {}", by, e);
        }

    }


    public boolean isDisplayed(By by) {
        try {
            logger.debug("Checking visibility of element: {}", by);
            findElement(by);
            logger.info("Element is visible: {}", by);
            return true;
        } catch (TimeoutException e) {
            logger.warn("Element is not visible within the timeout: {}", by);
            return false;
        } catch (Exception e) {
            logger.error("Unexpected error while checking element visibility: {}", by, e);
            return false;
        }
    }

    public boolean isDisplayedByTime(By by, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(time));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void sendKeys(By by, String text) {
        WebElement element = findElement(by);
        element.sendKeys(text);
        logger.info("Sent keys '{}' to element located by: {}", text, by);
    }


    public void sendEnter() {
        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(Keys.ENTER).perform();
        logger.info("ENTER key was sent using Actions.");
    }

    public void swipeUntilElementVisible(By by, int maxSwipes) {
        int swipeCount = 0;
        Dimension size = appiumDriver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.7);
        int endY = (int) (size.height * 0.3);

        while (swipeCount < maxSwipes) {
            try {
                WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                logger.info("Element located by {} is now visible after {} swipe(s).", by, swipeCount);
                return;
            } catch (TimeoutException e) {
                logger.warn("Swipe {} did not reveal element located by {}. Swiping again...", swipeCount + 1, by);
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1);

                swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                appiumDriver.perform(Collections.singletonList(swipe));
                swipeCount++;
            }
        }
        logger.error("Element located by {} was not found after {} swipe(s).", by, maxSwipes);
        throw new NoSuchElementException("Element not found after " + maxSwipes + " swipes: " + by.toString());
    }

    public void swipeforElements(By by, int maxSwipes) {
        int swipeCount = 0;
        Dimension size = appiumDriver.manage().window().getSize();
        Dimension sizeElememnt = findElements(by).get(1).getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.5);
        int endY = (int) (size.height * 0.5) - sizeElememnt.height;

        while (swipeCount < maxSwipes) {
            logger.info("Swiping to find more elements located by {}. Swipe count: {}", by, swipeCount + 1);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 2);

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            appiumDriver.perform(Collections.singletonList(swipe));
            swipeCount++;
        }
        logger.info("Completed {} swipe(s) for elements located by {}", maxSwipes, by);

    }

    public void clickElementOnListBack(By by, int index) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        List<WebElement> elemList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        elemList.get(elemList.size()-index).click();
        logger.info("Clicked on element at reverse index {} (actual index {}) located by {}", index, (elemList.size()-index), by);
    }

    public static By getProductByName(String productName) {
        return By.xpath("//android.widget.TextView[@resource-id='com.akakce.akakce:id/name' and @text=\"" + productName + "\"]");
    }
}

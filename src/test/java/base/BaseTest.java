package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static AppiumDriver driver;

    @Before
    public void browserConfigureOptions() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", ConfigReader.get("platformName"));
        caps.setCapability("appium:deviceName", ConfigReader.get("deviceName"));
        caps.setCapability("appium:automationName", ConfigReader.get("automationName"));
        caps.setCapability("appium:platformVersion", ConfigReader.get("platformVersion"));
        caps.setCapability("appium:appPackage", ConfigReader.get("appPackage"));
        caps.setCapability("appium:appActivity", ConfigReader.get("appActivity"));
        caps.setCapability("appium:noReset", ConfigReader.getBoolean("noReset"));
        caps.setCapability("appium:autoGrantPermissions", ConfigReader.getBoolean("autoGrantPermissions"));

        URL url = new URL(ConfigReader.get("appiumServerURL"));

        driver = new AndroidDriver(url, caps);
    }

    @After
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
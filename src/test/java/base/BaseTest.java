package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static AppiumDriver driver;

    @Before
    public void browserConfigureOptions() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:noReset", false);
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "16.0");
        caps.setCapability("appium:appPackage", "com.akakce.akakce");
        caps.setCapability("appium:appActivity", "com.akakce.akakce.ui.splash.SplashActivity");
        caps.setCapability("appium:autoGrantPermissions", true);

        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, caps);
    }

    @After
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
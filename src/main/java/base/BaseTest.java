package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("11.0")
                .setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setApp("C:/Users/krishnan.u/Downloads/ApiDemos-debug.apk")
                .setNewCommandTimeout(Duration.ofSeconds(3600))
                .setEnsureWebviewsHavePages(true)
                .setNativeWebScreenshot(true);

        // Set hardware keyboard manually
        options.setCapability("connectHardwareKeyboard", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    public AndroidDriver getDriver() {
        return driver;
    }
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
    }
}

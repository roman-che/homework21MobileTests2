package ru.inventorium.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import ru.inventorium.qa.config.RealConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static ru.inventorium.qa.utils.FileUtils.getAbsolutePath;

public class RealMobileDriver implements WebDriverProvider {

    public static RealConfig realConfig = ConfigFactory.create(RealConfig.class);
    String deviceName = realConfig.deviceName();
    String androidVersion = realConfig.androidVersion();
    String appPath = realConfig.appPath();


    @Override
    @Nonnull
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", androidVersion);
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app",
                getAbsolutePath(appPath));
        try {
            return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

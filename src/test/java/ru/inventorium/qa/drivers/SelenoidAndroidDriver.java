package ru.inventorium.qa.drivers;
import com.codeborne.selenide.WebDriverProvider;
import ru.inventorium.qa.config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidAndroidDriver implements WebDriverProvider {

    public static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class);
    String selenoidUrl = selenoidConfig.selenoidUrl();
    String selenoidAppVersion = selenoidConfig.selenoidAppVersion();
    String appPath = selenoidConfig.appPath();

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", selenoidAppVersion);

        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");

        desiredCapabilities.setCapability("app", appPath);
        try {
            return new AndroidDriver<>(new URL(selenoidUrl), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}


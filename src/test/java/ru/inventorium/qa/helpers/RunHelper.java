package ru.inventorium.qa.helpers;

import ru.inventorium.qa.config.RunConfig;
import ru.inventorium.qa.drivers.BrowserstackMobileDriver;
import ru.inventorium.qa.drivers.LocalAndroidDriver;
import ru.inventorium.qa.drivers.RealMobileDriver;
import ru.inventorium.qa.drivers.SelenoidAndroidDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunHelper {

    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "local":
                return LocalAndroidDriver.class;
            case "real":
                return RealMobileDriver.class;
            case "selenoid":
                return SelenoidAndroidDriver.class;
            case "null":
                throw new NullPointerException();
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }

}

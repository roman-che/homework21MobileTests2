package ru.inventorium.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/mobile.properties"})
public interface SelenoidConfig extends Config {

    @Key("selenoidUrl")
    String selenoidUrl();

    @Key("selenoidAppVersion")
    String selenoidAppVersion();

    @Key("appPath")
    String appPath();
}

package ru.inventorium.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/mobile.properties"})
public interface RealConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("androidVersion")
    String androidVersion();

    @Key("appPath")
    String appPath();


}

package ru.inventorium.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/mobile.properties"})
public interface RunConfig extends Config {

    @Key("deviceHost")
    @DefaultValue("local")
    String deviceHost();

}

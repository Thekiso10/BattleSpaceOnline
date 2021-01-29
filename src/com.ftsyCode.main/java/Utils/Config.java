package utils;

import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties {
    private InputStream externalConfig;

    public Config(){
        this.externalConfig = this.getClass().getResourceAsStream("/configs/config.properties");
    }

    /* Getters and Setters */
    public InputStream  getExternalConfig(){
        return this.externalConfig;
    }
}

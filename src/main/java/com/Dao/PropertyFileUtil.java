package com.Dao;

import java.io.InputStream;
import java.util.Properties;

class PropertiesFileUtil {

    public static Properties getPropertiesFromFile() {
        Properties properties = new Properties();
        try (InputStream input = PropertiesFileUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}

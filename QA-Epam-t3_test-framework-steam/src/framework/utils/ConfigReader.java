package framework.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static String getProperty(String key) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src/project/resources/configuration.property");
            prop.load(input);
            prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public static String getTestData(String key) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src/project/resources/dataConfig.properties");
            prop.load(input);
            prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}


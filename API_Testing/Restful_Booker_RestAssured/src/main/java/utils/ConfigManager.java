package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config/config.properties"
            );
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
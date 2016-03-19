package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by agustin on 18/03/16.
 */
public class Configuration {

    private static String configFile = "config/conf/config.cfg";

    private static int maxRandomValue;

    private static String specialCharacters;

    public static void loadProperties() {
        Properties props = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                props.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    file.close();
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        String tempMaxRandomValue = props.getProperty("maxRandomValue");
        maxRandomValue = Integer.parseInt(tempMaxRandomValue);
        specialCharacters = props.getProperty("specialCharacters");
    }

    public static int getMaxRandomValue() {
        return maxRandomValue;
    }

    public static String getSpecialCharacters() {
        return specialCharacters;
    }
}

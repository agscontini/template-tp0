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

    public static int maxRandomValue;

    public static String specialCharacters;

    public static void loadProperties() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream(configFile);
            props.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String tempMaxRandomValue = props.getProperty("maxRandomValue");
        maxRandomValue = Integer.parseInt(tempMaxRandomValue);
        specialCharacters = props.getProperty("specialCharacters");
        System.out.println("El archivo de configuracion se leyo correctamente");
    }
}

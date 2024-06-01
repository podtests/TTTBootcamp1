package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties property = new Properties();

    public static void loadFile() {
        File file  = new File("src/test/resources/qa.properties");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            property.load(fr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String propName) {
        return property.getProperty(propName);
    }

}

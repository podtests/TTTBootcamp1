package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.LoginPOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    public static Logger logger = LogManager.getLogger(ConfigReader.class.getName());

    public static Properties property = new Properties();

    public static void loadFile() {
        logger.info("loadFile method started");
        File file  = new File("src/test/resources/qa.properties");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            property.load(fr);
        } catch (FileNotFoundException e) {
            logger.error(e.getStackTrace().toString());
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error(e.getStackTrace().toString());
            throw new RuntimeException(e);
        }
        logger.info("loadFile method ended");

    }

    public static String getProperty(String propName) {
        return property.getProperty(propName);
    }

}

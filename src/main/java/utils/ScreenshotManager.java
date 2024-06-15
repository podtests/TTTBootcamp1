package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class ScreenshotManager {
    public static void takePageScreenshot(WebDriver wd, String name) {

        File file = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeElementScreenshot(WebElement we, String name) {

        File file = ((TakesScreenshot)we).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

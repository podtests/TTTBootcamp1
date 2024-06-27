package utils;

import com.google.common.primitives.Bytes;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class ScreenshotManager {
    public static byte[] takePageScreenshot(WebDriver wd, String name) {

        /*
        //zoom out
        new Actions(wd)
                .sendKeys(wd.findElement(By.tagName("html")), Keys.CONTROL, Keys.SUBTRACT)
                .perform();
        */

        JavascriptExecutor jsExecutor = (JavascriptExecutor) wd;
        jsExecutor.executeScript("document.body.style.zoom = '40%'");

        File file = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        byte[] screenshot = ((TakesScreenshot)wd).getScreenshotAs(OutputType.BYTES);
        try {
            FileUtils.copyFile(file, new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //reset the zoom:
        /*
        new Actions(wd)
                .sendKeys(wd.findElement(By.tagName("html")), Keys.CONTROL, "0")
                .perform();

         */
        jsExecutor.executeScript("document.body.style.zoom = '100%'");
        return screenshot;
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

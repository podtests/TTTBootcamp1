package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManage {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver init(String browserName) {
        driver.set(Driver.createSession(browserName));
        return driver.get();
    }

    public static WebDriver getSession() {
        return driver.get();
    }

    public static void close() {
        driver.remove();
    }


}

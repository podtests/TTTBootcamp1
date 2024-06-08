package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static WebDriver createSession(String browserName) {
        WebDriver wd = null;
        AbstractDriverOptions ado= null;

        if (browserName.equalsIgnoreCase("chrome")) {
            ado = new ChromeOptions();
            try {
                wd = new RemoteWebDriver(new URL("http://localhost:4444"),(ChromeOptions) ado);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            ado = new FirefoxOptions();
            try {
                wd = new RemoteWebDriver(new URL("http://localhost:4444"),(FirefoxOptions) ado);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            ado = new EdgeOptions();
            try {
                wd = new RemoteWebDriver(new URL("http://localhost:4444"),(EdgeOptions) ado);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return wd;
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDemo {

    public static void main(String[] args) throws MalformedURLException {

        String browserName = "chrome";

        WebDriver wd = null;

        if(browserName.equalsIgnoreCase("chrome")) {

            wd = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
           wd = new FirefoxDriver();
        }

        wd.get("https://podtest.in");









    }
}

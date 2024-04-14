import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDemo {

    public static void main(String[] args) throws MalformedURLException {

        //WebDriver wd = new ChromeDriver();
        //ChromeOptions option = new ChromeOptions();
        //WebDriver wd1 = new RemoteWebDriver(new URL("http://localhost:4444"),option);
        WebDriver wd = new ChromeDriver();


        wd.get("https://demo.evershop.io/account/login");

        wd.navigate().forward();

        //locator strategy : xpath
        //wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");

        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");

        wd.findElement(By.tagName("input")).sendKeys("password");

        //wd.findElement()














    }
}

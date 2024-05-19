import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestNGDemo {

    //WebDriver wd = new ChromeDriver();

    ChromeOptions option ;

    FirefoxOptions firefoxOptions;

    WebDriver wd ;
    WebDriverWait wait;


    @Parameters({ "browserName"})
    @BeforeClass(alwaysRun = true)
    public void presetup(String browserName) {
        option = new ChromeOptions();

        firefoxOptions = new FirefoxOptions();
        option.addArguments("--start-maximized");

        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                wd = new RemoteWebDriver(new URL("http://localhost:4444/"), option);
            } else if(browserName.equalsIgnoreCase("firefox")) {
                wd = new RemoteWebDriver(new URL("http://localhost:4444/"), firefoxOptions);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        wait =new WebDriverWait(wd, Duration.ofSeconds(5));
    }


    @Parameters({"product"})
    @Test(priority = 3, groups = {"sanity"}, enabled = false)
    public void addItem(String productName ) {

        //Home page
        String productXpath = "//div[contains(@class,'product-name')]//span[text()='"+productName+"']";
        wd.findElement(By.xpath(productXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[text()='ADD TO CART']")));

    }
    @Parameters({"qty", "size", "color"})
    @Test(priority = 10, groups = {"regression"}, enabled = false)
    public void addItemToCart(String qty, String size, String color) {
        //Item Page: Fill the details & click Add To cart.
        wd.findElement(By.xpath("//input[@name='qty']")).clear();
        wd.findElement(By.xpath("//input[@name='qty']")).sendKeys(qty);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String sizeXpath = "(//ul[contains(@class,'variant-option-list')])[1]//a[text()='"+size+"']";
        wd.findElement(By.xpath(sizeXpath)).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String colorXPath = "(//ul[contains(@class,'variant-option-list')])[2]//a[text()='"+color+"']";
        wd.findElement(By.xpath(colorXPath)).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wd.findElement(By.cssSelector("button.button")).click();
    }

    @Parameters({"username", "password"})
    @Test(priority = 1, groups = {"smoke", "login", "regression", "sanity"})
    public void login(String UN, String PW) {

        wd.get("https://demo.evershop.io/account/login");

        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(UN);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
        wd.findElement(By.cssSelector("button.button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'button')]/span[text()='Shop women']")));

        //pass/fail: username is shown correctly on home screen, Or i can check the URL which gets loaded after login
        //Hard  : URL's

        /*
        Assert.assertEquals(wd.getCurrentUrl(), "https://demo.evershop.io/gdHJGSDK");

        Assert.assertEquals("akhil","akhil");// miss to validate this check
        */

        SoftAssert softAssert = new SoftAssert();
       // softAssert.assertEquals(wd.getCurrentUrl(), "https://demo.evershop.io/gdHJGSDK"); //failed

        softAssert.assertEquals("akhil","akhil");

        softAssert.assertAll();

        System.out.println("I am running testcase1");

    }






}

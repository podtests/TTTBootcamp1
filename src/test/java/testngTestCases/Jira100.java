package testngTestCases;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pom.HomePOM;
import pom.ItemPOM;
import pom.LoginPOM;
import utils.ConfigReader;
import utils.DriverManage;
import utils.ExcelManager;
import utils.ScreenshotManager;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.time.LocalTime;

public class Jira100 extends BaseTest {

    LoginPOM loginPOM ;

    HomePOM homePOM;
    ItemPOM itemPOM;


    public static Logger logger = LogManager.getLogger(Jira100.class.getName());


    @BeforeSuite
    public void preSuite() {
        logger.info("preSuite method started");
        logger.info("CurrentThreadName is: "+Thread.currentThread().getName());
        ConfigReader.loadFile();
        logger.info("preSuite method completed");
    }


    @BeforeSuite
    @DataProvider(name="credentials", parallel = true)
    public Object[][] readDataSource() {
        logger.info("readDataSource method started");
        logger.info("CurrentThreadName is: "+Thread.currentThread().getName());
        ExcelManager em = new ExcelManager();
        String[][] str = em.readFile();
        logger.info("readDataSource method completed");
        return str;
    }

    /*
    @BeforeMethod
    public void preMethod(Object[] testData) {
        logger.info("TC: preMethod started");
        logger.info("preMethod: CurrentThreadName is: "+Thread.currentThread().getName());
        DriverManage.init((String)testData[0]);
        logger.info("TC: preMethod Completed");
    }

    @AfterMethod
    public void postMethod() {
        logger.info("TC: postMethod started");
        logger.info("postMethod: CurrentThreadName is: "+Thread.currentThread().getName());
        DriverManage.getSession().quit();
        DriverManage.close();
        logger.info("TC: postMethod Completed");
    }
     */

    @Test(testName = "addItemToCartTest",  dataProvider = "credentials")
    public void addItemToCartTest(String browserName, String UN, String PW, String itemName) {
        long id = Thread.currentThread().getId();
        Thread.currentThread().setName("addItemToCartTest Thread: "+id);
        logger.info("TC: addItemToCartTest started");
        logger.info("CurrentThreadName is: "+Thread.currentThread().getName());
        WebDriver wd = DriverManage.getSession();
        loginPOM = new LoginPOM(wd);

        loginPOM.get().fillUserName(UN).fillPassword(PW).clickSignIn()
                .isPageLoaded().clickItem(itemName)
                .isPageLoaded().fillQty("2").selectSize("L").selectColor("Grey").clickAddItemToCart();

        //ScreenshotManager.takePageScreenshot(wd, "addItemToCartTest");

        logger.info("TC: addItemToCartTest Completed");


        //Login screen
        /*
        loginPOM.get().fillUserName(UN).fillPassword(PW).clickSignIn();
        homePOM.isPageLoaded().clickItem(itemName);
        */

        //Home screen

    }


    @Test(testName = "checkShoppingButtons", dataProvider = "credentials")
    public void checkShoppingButtons(String browserName, String UN, String PW, String itemName) {
        long id = Thread.currentThread().getId();
        Thread.currentThread().setName("checkShoppingButtons Thread: "+id);
        logger.info("TC: checkShoppingButtons started");
        logger.info("checkShoppingButtons CurrentThreadName is: "+Thread.currentThread().getName());
        WebDriver wd = DriverManage.getSession();

        loginPOM = new LoginPOM(wd);

        boolean buttonCountMatch = loginPOM.get().fillUserName(UN).fillPassword(PW).clickSignIn()
                .isPageLoaded().checkShopppingButtonsCount(3);


        //ScreenshotManager.takePageScreenshot(wd, "checkShoppingButtons");

            Assert.assertTrue(false);


        logger.info("TC: checkShoppingButtons Completed");



        //Login screen
        /*
        loginPOM.get().fillUserName(UN).fillPassword(PW).clickSignIn();
        homePOM.isPageLoaded().clickItem(itemName);
        */

        //Home screen

    }




    @Test(enabled = false)
    public void loginSuccess(String UN, String PW) {
        WebDriver wd = new ChromeDriver();

        loginPOM = new LoginPOM(wd);

        loginPOM.get().fillUserName(UN).fillPassword(PW).clickSignIn();

                //.fillUserName(UN).fillPassword(PW).clickSignIn();


        /*
        loginPOM.get();
        loginPOM.fillUserName(UN);
        loginPOM.fillPassword(PW);
        loginPOM.clickSignIn();
        */

        /*
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys(UN);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
        wd.findElement(By.xpath("//button[contains(@class,'primary')]")).click();
*/

        String currentURL = wd.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://demo.evershop.io/" );

    }

    @Parameters({"username", "password"})
    @Test(enabled = false)
    public void loginUnSuccess(String UN, String PW) {
        WebDriver wd = new ChromeDriver();
        wd.findElement(By.xpath("")).sendKeys(UN);
        wd.findElement(By.xpath("")).sendKeys(PW);
        wd.findElement(By.xpath("")).click();

        String currentURL = wd.getCurrentUrl();
        Assert.assertEquals(currentURL,"" );

    }

}

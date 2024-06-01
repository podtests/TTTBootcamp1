package testngTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.HomePOM;
import pom.ItemPOM;
import pom.LoginPOM;
import utils.ConfigReader;
import utils.ExcelManager;

import java.io.ObjectInputFilter;

public class Jira100 {

    LoginPOM loginPOM ;

    HomePOM homePOM;
    ItemPOM itemPOM;



    @BeforeSuite
    public void preSuite() {
        ConfigReader.loadFile();
    }


    @DataProvider(name="credentials")
    public Object[][] readDataSource() {
        ExcelManager em = new ExcelManager();
        return em.readFile();
    }

    @Test(dataProvider = "credentials")
    public void addItemToCartTest(String UN, String PW, String itemName) {
        WebDriver wd = new ChromeDriver();
        loginPOM = new LoginPOM(wd);

        loginPOM.get().fillUserName(UN).fillPassword(PW).clickSignIn()
                .isPageLoaded().clickItem(itemName)
                .isPageLoaded().fillQty("2").selectSize("L").selectColor("Grey").clickAddItemToCart();

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

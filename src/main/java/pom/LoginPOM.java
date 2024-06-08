package pom;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class LoginPOM {

    public static Logger logger = LogManager.getLogger(LoginPOM.class.getName());

    //String userNameTextBox1 = "//input[@name='email']";
    By userNameTextBox = By.xpath("//input[@name='email']");
    By passwordTextBox = By.xpath("//input[@name='password']");
    By signInButton = By.xpath("//button[contains(@class,'primary')]");

    WebDriver wd  = null;



    public LoginPOM(WebDriver wd) {
        logger.info("LoginPOM Constructor Started with session id as:"+((RemoteWebDriver)wd).getSessionId().toString());
        this.wd = wd;
        logger.info("LoginPOM Constructor Completed");
    }

    public LoginPOM get() {
        logger.info("get method started");
        wd.get(ConfigReader.getProperty("url"));
        logger.info("get method completed");
        return this;
    }

    public LoginPOM fillUserName(String UN) {
        //Hard coding : what startegy to use: xpath
       // wd.findElement(By.cssSelector(userNameTextBox1)).sendKeys(UN);

        //
        logger.info("fillUserName method started");
        logger.debug("Username used is: "+UN);
        wd.findElement(userNameTextBox).sendKeys(UN);
        logger.info("fillUserName method completed");
        return this;
    }

    public LoginPOM fillPassword(String PW) {
        logger.info("fillPassword method started");
        logger.debug("Password used is: "+PW);
        wd.findElement(passwordTextBox).sendKeys(PW);
        logger.info("fillPassword method completed");
        return this;
    }

    public HomePOM clickSignIn() {
        logger.info("clickSignIn method started");

        WebElement we = wd.findElement(signInButton);
        File file = we.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("src/test/resources/screenshots/clickSignIn"+ LocalTime.now().getSecond() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        we.click();
        logger.info("clickSignIn method Completed");
        return new HomePOM(wd);
    }

    public void logIn(String UN, String PW) {
       // wd.findElement(By.cssSelector(userNameTextBox1)).sendKeys(UN);

        wd.findElement(userNameTextBox).sendKeys(UN);
        wd.findElement(passwordTextBox).sendKeys(PW);
        wd.findElement(signInButton).click();
    }
}

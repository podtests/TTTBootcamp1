package pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePOM {

    public static Logger logger = LogManager.getLogger(HomePOM.class.getName());
    String itemXpath= "//div[contains(@class,'product-name')]//span[text()='$$']";

    By shopWomenButton = By.xpath("//a/span[text()='Shop women']");
    WebDriver wd;
    WebDriverWait wait;

    public HomePOM(WebDriver wd) {
        logger.info("HomePOM Constructor Started with session id as:"+((ChromeDriver)wd).getSessionId().toString());
        this.wd = wd;
        wait = new WebDriverWait(this.wd, Duration.ofSeconds(5000));
        logger.info("HomePOM Constructor Completed");
    }

    public HomePOM isPageLoaded() {
        logger.info("isPageLoaded method started");
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopWomenButton));
        logger.info("isPageLoaded method completed");
        return this;
    }


    //Mix and match chuck taylor all star
    public ItemPOM clickItem(String itemName) {
        logger.info("clickItem method started");
        logger.debug("Item name to be clicked is: "+itemName);
        wd.findElement(By.xpath(itemXpath.replace("$$",itemName))).click();
        logger.info("clickItem method completed");
        return new ItemPOM(wd);
    }
}

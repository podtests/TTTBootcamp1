package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePOM {

    String itemXpath= "//div[contains(@class,'product-name')]//span[text()='$$']";

    By shopWomenButton = By.xpath("//a/span[text()='Shop women']");
    WebDriver wd;
    WebDriverWait wait;

    public HomePOM(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(this.wd, Duration.ofSeconds(5000));
    }

    public HomePOM isPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopWomenButton));
        return this;
    }


    //Mix and match chuck taylor all star
    public ItemPOM clickItem(String itemName) {
        wd.findElement(By.xpath(itemXpath.replace("$$",itemName))).click();
        return new ItemPOM(wd);
    }
}

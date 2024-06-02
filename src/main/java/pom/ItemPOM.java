package pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPOM {

    public static Logger logger = LogManager.getLogger(ItemPOM.class.getName());

    WebDriver wd;

    WebDriverWait wait;

    By qtyTextBox = By.xpath("//input[@name='qty']");
    String sizeBox = "(//ul[contains(@class,'variant-option-list')])[1]//a[text()='$$']";

    String colorBox = "(//ul[contains(@class,'variant-option-list')])[2]//a[text()='Grey']";

    By addToCartButton = By.xpath("//button/span[text()='ADD TO CART']");

    public ItemPOM(WebDriver wd) {
        logger.info("ItemPOM Constructor Started with session id as:"+((ChromeDriver)wd).getSessionId().toString());
        this.wd = wd;
        wait = new WebDriverWait(this.wd, Duration.ofSeconds(5000));
        logger.info("ItemPOM Constructor Completed");
    }

    public ItemPOM isPageLoaded() {
        logger.info("isPageLoaded method Started");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        logger.info("isPageLoaded method Completed");
        return this;
    }


    public ItemPOM fillQty(String qty) {
        logger.info("fillQty method Started");
        logger.debug("Quantity to be filled is: "+qty);
        wd.findElement(qtyTextBox).clear();
        wd.findElement(qtyTextBox).sendKeys(qty);
        logger.info("fillQty method Completed");
        return this;
    }

    public ItemPOM selectSize(String size) {
        logger.info("selectSize method Started");
        logger.debug("Item Size is: "+size);
        wd.findElement(By.xpath(sizeBox.replace("$$", size))).click();
        logger.info("selectSize method Completed");
        return this;
    }

    public ItemPOM selectColor(String color) {
        logger.info("selectColor method Started");
        logger.debug("Item color is: "+color);
        wd.findElement(By.xpath(colorBox.replace("$$", color))).click();
        logger.info("selectColor method Completed");
        return this;
    }

    public ItemPOM clickAddItemToCart() {
        logger.info("clickAddItemToCart method Started");
        wd.findElement(addToCartButton).click();
        logger.info("clickAddItemToCart method Completed");
        return this;
    }


}

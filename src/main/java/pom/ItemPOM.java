package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPOM {

    WebDriver wd;

    WebDriverWait wait;

    By qtyTextBox = By.xpath("//input[@name='qty']");
    String sizeBox = "(//ul[contains(@class,'variant-option-list')])[1]//a[text()='$$']";

    String colorBox = "(//ul[contains(@class,'variant-option-list')])[2]//a[text()='Grey']";

    By addToCartButton = By.xpath("//button/span[text()='ADD TO CART']");

    public ItemPOM(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(this.wd, Duration.ofSeconds(5000));
    }

    public ItemPOM isPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        return this;
    }


    public ItemPOM fillQty(String qty) {
        wd.findElement(qtyTextBox).clear();
        wd.findElement(qtyTextBox).sendKeys(qty);
        return this;
    }

    public ItemPOM selectSize(String size) {
        wd.findElement(By.xpath(sizeBox.replace("$$", size))).click();
        return this;
    }

    public ItemPOM selectColor(String color) {
        wd.findElement(By.xpath(colorBox.replace("$$", color))).click();
        return this;
    }

    public ItemPOM clickAddItemToCart() {
        wd.findElement(addToCartButton).click();
        return this;
    }


}

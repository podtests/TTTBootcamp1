package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

    //String userNameTextBox1 = "//input[@name='email']";
    By userNameTextBox = By.xpath("//input[@name='email']");
    By passwordTextBox = By.xpath("//input[@name='password']");
    By signInButton = By.xpath("//button[contains(@class,'primary')]");

    WebDriver wd  = null;

    public LoginPOM(WebDriver wd1) {
       wd = wd1;
    }

    public LoginPOM get() {
        wd.get("https://demo.evershop.io/account/login");
        return this;
    }

    public LoginPOM fillUserName(String UN) {
        //Hard coding : what startegy to use: xpath
       // wd.findElement(By.cssSelector(userNameTextBox1)).sendKeys(UN);

        //
        wd.findElement(userNameTextBox).sendKeys(UN);
        return this;
    }

    public LoginPOM fillPassword(String PW) {
        wd.findElement(passwordTextBox).sendKeys(PW);
        return this;
    }

    public HomePOM clickSignIn() {
        wd.findElement(signInButton).click();
        return new HomePOM(wd);
    }

    public void logIn(String UN, String PW) {
       // wd.findElement(By.cssSelector(userNameTextBox1)).sendKeys(UN);

        wd.findElement(userNameTextBox).sendKeys(UN);
        wd.findElement(passwordTextBox).sendKeys(PW);
        wd.findElement(signInButton).click();
    }
}

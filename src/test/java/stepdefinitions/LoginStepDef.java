package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDef {

    WebDriver wd = new ChromeDriver();

    @When("User fills credentials as {string} and {string}")
    public void fillCredentials(String UN, String PW){

        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(UN);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
        wd.findElement(By.cssSelector("button.button")).click();
    }

    @Given("User opens the URL")
    public void openURL() {
        wd.get("https://demo.evershop.io/account/login");
    }


    @When("User fills username as {string}")
    public void fillUserName(String UN) {
        System.out.println("UN is "+UN);
        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(UN);
    }

    @When("User fills password as {string}")
    public void fillPassword(String PW) {
        System.out.println("PW is "+PW);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
    }

    @When("User clicks on Submit")
    public void clickSubmit() {
        wd.findElement(By.cssSelector("button.button")).click();
    }

    @Then("User should be able to login successfully")
    public void validate() {
        System.out.println("I am loggedIn");
    }
}

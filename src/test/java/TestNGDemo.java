import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

    WebDriver wd;

    @BeforeMethod
    public void m1() {
        wd = new ChromeDriver();
        wd.get("https://demo.evershop.io/account/login");
        System.out.println("running before hook");
    }

    @Test
    public void login() {

        wd.findElement(By.cssSelector("input[name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
        wd.findElement(By.cssSelector("button.button")).click();
        System.out.println("running test ");
    }


    @Test
    public void nlogin() {
        WebDriver wd = new ChromeDriver();
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.cssSelector("input[name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("fsdhgkdjhwkjd");
        wd.findElement(By.cssSelector("button.button")).click();
    }

    @AfterMethod
    public void m2() {
        wd.close();
       // wd = null;

        System.out.println("running After hook");
    }


}

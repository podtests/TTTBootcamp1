import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGDemo2 {

    @Test
    public void n2login() {
        WebDriver wd = new ChromeDriver();
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.cssSelector("input[name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("ghdfh");
        wd.findElement(By.cssSelector("button.button")).click();
    }


    @Test
    public void n3login() {
        WebDriver wd = new ChromeDriver();
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.cssSelector("input[name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("fgsdfgsdf");
        wd.findElement(By.cssSelector("button.button")).click();
    }


}

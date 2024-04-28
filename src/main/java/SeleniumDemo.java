import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class SeleniumDemo {
    ChromeOptions option = new ChromeOptions();
     WebDriver wd = null;
    WebDriverWait wait = null;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
      SeleniumDemo sd = new SeleniumDemo();
      sd.basicSetup();
      sd.iFrameSection();



    }


    public void iFrameSection() {
        wd.get("https://selectorshub.com/iframe-scenario/");

        wd.switchTo().frame("pact1");


        wd.switchTo().frame("pact2");
        wd.findElement(By.xpath("//input[@id='jex']")).sendKeys("jain");


        //wd.switchTo().parentFrame();
        wd.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Akhil");

        //input[@id='inp_val']
    }

    public void fillItemCart() {

        By qty = By.cssSelector("input[name=qty]");
        wait.until(ExpectedConditions.elementToBeClickable(qty));
        wd.findElement(qty).clear();
        wd.findElement(qty).sendKeys("2");

        //size
        By size = By.xpath("(//ul[contains(@class,'variant-option-list')])[1]//li/a[text()='M']");
        wd.findElement(size).click();

        By sizeparent = By.xpath("(//ul[contains(@class,'variant-option-list')])[1]//li/a[text()='M']//parent::li");
        wait.until(ExpectedConditions.attributeContains(sizeparent,"class", "selected" ));

        //color
        By color = By.xpath("(//ul[contains(@class,'variant-option-list')])[2]//li/a[text()='Black']");
        wd.findElement(color).click();

        By colorParent = By.xpath("(//ul[contains(@class,'variant-option-list')])[2]//li/a[text()='Black']//parent::li");
        wait.until(ExpectedConditions.attributeContains(colorParent,"class", "selected" ));

        //add to cart
        wd.findElement(By.xpath("//button/span[text()='ADD TO CART']")).click();

        //click on view cart
        By viewCartLink = By.xpath("//a[@class='add-cart-popup-button']");
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        wd.findElement(viewCartLink).click();

        System.out.println(wd.getTitle());








        //By color = By.xpath("(//ul[contains(@class,'variant-option-list')])[2]//li/a[text()='Black']");



    }

    public void clickItem() {
        By item = By.xpath("//span[text()='Nike air zoom pegasus 35']");
        wait.until(ExpectedConditions.elementToBeClickable(item));
        wd.findElement(item).click();
    }

    public void basicSetup() throws MalformedURLException, InterruptedException {

        //option.addArguments("--headless");

        wd = new RemoteWebDriver(new URL("http://localhost:4444"),option );
            wait = new WebDriverWait(wd, Duration.ofSeconds(5000));
        wd.get("https://demo.evershop.io/account/login");

    }

    public void login() {
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");

        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void workingWithToastBox() {

    }


    public void normalAlertBox() throws InterruptedException {
        wd.get("http://127.0.0.1:5500/htmlcssjspage.html");

        wd.findElement(By.cssSelector("input[id=submit]")).click();

        Thread.sleep(5000);

        Alert a1 = wd.switchTo().alert();
        System.out.println(a1.getText());
        a1.accept();

    }

    public void multipleWindow() throws InterruptedException {
        //Browser level:
        wd.manage().window().maximize();
        SessionId session = ((RemoteWebDriver)wd).getSessionId();


        wd.get("https://selectorshub.com/xpath-practice-page/");

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5000));
        String defaultHandle = wd.getWindowHandle();

        System.out.println("Pre Handles: "+wd.getWindowHandle());  //



        By linkText = By.xpath("//h2[contains(@class, 'elementor-heading-title')]/a[text()='Find out how to automate these controls without XPath']");
        wait.until(ExpectedConditions.elementToBeClickable(linkText));
        wd.findElement(linkText).click();

        System.out.println("Post Handle: "+wd.getWindowHandle());

        //print all windows opened up
        System.out.println("All handles");
        Set<String> handles =wd.getWindowHandles();

        Map<Integer, String> tabMap = new HashMap<Integer, String>();

        Thread.sleep(5000);

        System.out.println(wd.getTitle());

        int i =0;
        for (String s : handles) {
            tabMap.put(i,s);
            i++;
        }

        for(Integer j : tabMap.keySet()) {
            System.out.println("Key is:"+j+ "TabHandle Id is:"+tabMap.get(j));
        }

        wd.switchTo().window(tabMap.get(1));

        /*
        By caseStudiesSubTab = By.xpath("//a[text()='Case Studies']");
        wait.until(ExpectedConditions.elementToBeClickable(caseStudiesSubTab));
        wd.findElement(caseStudiesSubTab).click();
*/


    }



}

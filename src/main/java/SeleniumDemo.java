import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class SeleniumDemo {
    ChromeOptions option = new ChromeOptions();
    WebDriver wd = null;



    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        SeleniumDemo d1 = new SeleniumDemo();
        d1.basicSetup();
        d1.login();
        d1.clickItem();
        d1.openCartPage();
        d1.readTableContent();


    }

    public void openCartPage() {
        wd.navigate().to("https://demo.evershop.io/cart");
    }

    public int getRowCount() {
        int rowCount = wd.findElements(By.xpath("//table[contains(@class,'items-table')]/tbody/tr")).size();
        return rowCount;
    }


    public int colCount() {
        int colCount = wd.findElements(By.xpath("//table[contains(@class,'items-table')]/thead/tr/td")).size();
        return colCount;
    }

    public void readTableContent() {


        //default way
        /*
        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[1]/td[1]//div[@class='cart-tem-info']/a")).getText();
        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[1]/td[2]/div[1]/span")).getText();
        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[1]/td[3]/span")).getText();
        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[1]/td[4]/span")).getText();

        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[2]/td[1]//div[@class='cart-tem-info']/a")).getText();
        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[2]/td[2]/div[1]/span")).getText();
        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[2]/td[3]/span")).getText();
        wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr[2]/td[4]/span")).getText();

*/


        System.out.println("-----------------------------------------------------");


        //Approach1
        List<WebElement> ddRows = wd.findElements(By.xpath("//table[contains(@class,'items-table')]/tbody/tr"));

        Iterator<WebElement> ite1 = ddRows.iterator();
        WebElement e = null;
        while(ite1.hasNext()) {
            e = ite1.next();
            System.out.println(e.findElement(By.xpath("td[1]//div[@class='cart-tem-info']/a")).getText());
            System.out.println(e.findElement(By.xpath("td[2]/div[1]/span")).getText());
            System.out.println(e.findElement(By.xpath("td[3]/span")).getText());
            System.out.println(e.findElement(By.xpath("td[4]/span")).getText());
        }

        System.out.println("-----------------------------------------------------");

        //Approach2
        for(WebElement e1 : ddRows) {
            System.out.println(e1.findElement(By.xpath("td[1]//div[@class='cart-tem-info']/a")).getText());
            System.out.println(e1.findElement(By.xpath("td[2]/div[1]/span")).getText());
            System.out.println(e1.findElement(By.xpath("td[3]/span")).getText());
            System.out.println(e1.findElement(By.xpath("td[4]/span")).getText());
        }

        System.out.println("-----------------------------------------------------");

        //Approach3
        for(int i =1; i <= getRowCount(); i++){
            System.out.println(wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr["+i+"]/td[1]//div[@class='cart-tem-info']/a")).getText());
            System.out.println(wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr["+i+"]/td[2]/div[1]/span")).getText());
            System.out.println(wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr["+i+"]/td[3]/span")).getText());
            System.out.println(wd.findElement(By.xpath("//table[contains(@class,'items-table')]/tbody/tr["+i+"]/td[4]/span")).getText());
        }













    }

    public void getColnames() {

        //wd.findElement().

        List<WebElement> colNameElements = wd.findElements(By.xpath("//table[contains(@class,'items-table')]/thead/tr/td"));
       //Approach1
        Iterator<WebElement> it1 = colNameElements.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next().findElement(By.xpath("span")).getText());
        }

        System.out.println("---------------------------------");

        //Approach2
        for(WebElement e : colNameElements) {
            System.out.println(e.findElement(By.xpath("span")).getText());
        }
        System.out.println("---------------------------------");

        //Approach3:
        for(int i = 1; i <=colNameElements.size(); i++) {
            String colName = wd.findElement(By.xpath("//table[contains(@class,'items-table')]/thead/tr/td["+i+"]/span")).getText();
            System.out.println(colName);
        }

        //System.out.println(rowCount);

    }

    public void basicSetup() throws MalformedURLException {
        wd = new RemoteWebDriver(new URL("http://localhost:4444"),option);
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        wd.get("https://demo.evershop.io/account/login");

    }

    public void clickItem() {
        wd.findElement(By.xpath("//span[text()='Nike air zoom pegasus 35']")).click();
    }

    public void fillItemCart() {
        wd.findElement(By.xpath("//input[@name='qty']")).clear();


        /*
        //Link click
         wd.findElement(By.xpath("//span[text()='Nike air zoom pegasus 35']")).click();


        //Item Page: adding item to cart
        wd.findElement(By.xpath("//input[@name='qty']")).clear();
        wd.findElement(By.xpath("//input[@name='qty']")).sendKeys("2");

        wd.findElement(By.xpath("(//ul[contains(@class,'variant-option-list')])[1]//a[text()='M']")).click();
        wd.findElement(By.xpath("(//ul[contains(@class,'variant-option-list')])[2]//a[text()='Black']")).click();

        Thread.sleep(3000);

        wd.findElement(By.xpath("//span[text()='ADD TO CART']")).click();
        */
    }

    public void login() {
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");

        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void basicOperations() {
        //Fill Text in Input Field
        wd.findElement(By.name("email")).sendKeys("jhasgdkjhsdkjjadsklfjaskldf");
        wd.findElement(By.name("email")).clear();

        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");



        String expectedButtontext ="SIGN IN";

        String actualText = wd.findElement(By.xpath("//button[@type='submit']/span")).getText();

        if (expectedButtontext.equals(actualText)) {
            //if (expectedButtontext==actualText) {
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        String val = wd.findElement(By.name("email")).getAttribute("placeholder");
        System.out.println(val);

        //Button: Click
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }

    public void navigateCheckout() {
        wd.navigate().to("https://demo.evershop.io/checkout");
    }

    public void dropdowns() {
        WebElement countryDDElement = wd.findElement(By.xpath("//select[contains(@id,'country')]"));

        //Select
        Select countryDD = new Select(countryDDElement);
        countryDD.selectByValue("CN");
        countryDD.selectByIndex(0);


        //findelements
        countryDDElement.click();
        List<WebElement> ddOptions =   wd.findElements(By.xpath("//select[contains(@id,'country')]/option"));
        // ddOptions.get(1).click();

        //print all the options rom my dropdown:
        Iterator<WebElement> ite = ddOptions.iterator();

        WebElement e1 = null;
        while(ite.hasNext()) {
            e1 = ite.next();
            if(e1.getText().toUpperCase().equals("china".toUpperCase())) {
                e1.click();
            }

        }
    }


}

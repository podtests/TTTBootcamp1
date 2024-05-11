import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.LogLevel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;

public class SeleniumTopics {

    public static void main(String[] args) throws InterruptedException {

        LoggingPreferences pref = new LoggingPreferences();
        pref.enable(LogType.BROWSER, Level.ALL);
        WebDriver wd = new ChromeDriver();

        wd.get("https://demo.evershop.io/account/login");

        System.out.println(wd.findElement(By.cssSelector("button[type='submit']"))
                        //.get
                //.getDomAttribute("ATTRIBUTE_NODE")
                .getRect().getWidth()
        );

        /*
        Point  pt =  wd.manage().window().getPosition();
        int x = pt.getX();
        int y = pt.getY();

        Dimension dm = wd.manage().window().getSize();
        System.out.println("H: "+ dm.height);
        System.out.println("W: "+dm.width);

        System.out.println("X is:"+x+" , y is:"+y);

        wd.manage().window().setPosition(pt.moveBy(10, 20));

        Point  pt1 =  wd.manage().window().getPosition();
        int x1 = pt1.getX();
        int y1 = pt1.getY();

        System.out.println("X1 is:"+x1+" , y1 is:"+y1);

        Dimension dm2 = wd.manage().window().getSize();
        System.out.println("H: "+ dm2.height);
        System.out.println("W: "+dm2.width);

        Dimension dm3 = new Dimension(200, 500);
        wd.manage().window().setSize(dm3);

        Point p = new Point(0,3000);
        //wd.manage().window().setPosition(p);
        //wd.manage().window().minimize();

        */


        /*
        wd.get("https://www.thetesttribe.com/");
        Set<String> log =  wd.manage().logs().getAvailableLogTypes();

        for(String s : log){
            System.out.println(s);
        }

        Thread.sleep(10000);

        //Iterator<LogEntry> ble =wd.manage().logs().get("browser").getAll().iterator();
        for( LogEntry e :wd.manage().logs()
                .get("browser").getAll()) {
            System.out.println(e.getLevel().getName()+" , "+ e.getMessage());
        }

        System.out.println("-------------");

        for( LogEntry e :wd.manage().logs().get("client").getAll()) {
            System.out.println(e.getLevel().getName()+" , "+ e.getMessage());
        }
        System.out.println("-------------");

        for( LogEntry e :wd.manage().logs().get("driver").getAll()) {
            System.out.println(e.getLevel().getName()+" , "+ e.getMessage());
        }

        System.out.println(wd.getPageSource());
        */





    }
}

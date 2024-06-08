package testngTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManage;

public class BaseTest {
    public static Logger logger = LogManager.getLogger(Jira100.class.getName());

    @Parameters({"browser"})
    @BeforeMethod()
    public void preMethod(String browserName) {
        logger.info("TC: preMethod started");
        logger.info("preMethod: CurrentThreadName is: "+Thread.currentThread().getName());
        DriverManage.init(browserName);
        logger.info("TC: preMethod Completed");
    }


    @AfterMethod
    public void postMethod() {
        logger.info("TC: postMethod started");
        logger.info("postMethod: CurrentThreadName is: "+Thread.currentThread().getName());
        DriverManage.getSession().quit();
        DriverManage.close();
        logger.info("TC: postMethod Completed");
    }
}

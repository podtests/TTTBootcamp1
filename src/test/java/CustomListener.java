import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;
import testngTestCases.Jira100;
import utils.DriverManage;
import utils.ScreenshotManager;

import java.time.LocalTime;

public class CustomListener implements ITestListener {

    public static Logger logger = LogManager.getLogger(CustomListener.class.getName());

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("-----------Error Occurred---------");
        logger.error(result.getThrowable().getMessage());
        for(StackTraceElement s : result.getThrowable().getStackTrace()) {
            logger.error(s.toString());
        }

        String dirName = "src\\test\\resources\\screenshots\\";
        String logDirName = "src\\test\\resources\\logs\\tc.log";
        String fileName = dirName+result.getName()+LocalTime.now().getMinute()+LocalTime.now().getSecond()+".png";
        ScreenshotManager.takePageScreenshot(DriverManage.getSession(),fileName);

        Reporter.log("<a href='..\\..\\"+fileName+"'>Screenshot</a> ");
        //Reporter.log("<a href='..\\..\\"+logDirName+"'>logFile</a> ");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        String dirName = "src\\test\\resources\\screenshots\\";
        String fileName = dirName+result.getName()+LocalTime.now().getMinute()+LocalTime.now().getSecond()+".png";
        ScreenshotManager.takePageScreenshot(DriverManage.getSession(),fileName);

        Reporter.log("<a href='..\\..\\"+fileName+"'>Screenshot</a> ");
    }


}

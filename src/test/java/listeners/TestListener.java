package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extentReports =
            ExtentManager.getReportObject();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extentReports.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        String testName = result.getName();

        ScreenshotUtil.captureScreenshot(
                new BaseTest().getDriver(),
                testName
        );

        String screenshotPath = System.getProperty("user.dir")
                + "/screenshots/"
                + testName + ".png";

        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extentReports.flush();
    }
}
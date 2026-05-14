package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extentReports;

    public static ExtentReports getReportObject() {

        String reportPath = System.getProperty("user.dir")
                + "/reports/TestReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(reportPath);

        reporter.config().setReportName("Automation Test Results");

        reporter.config().setDocumentTitle("Selenium Framework Report");

        extentReports = new ExtentReports();

        extentReports.attachReporter(reporter);

        extentReports.setSystemInfo("Tester", "Vinod");

        return extentReports;
    }
}
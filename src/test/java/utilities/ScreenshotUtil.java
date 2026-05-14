package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File(
                System.getProperty("user.dir")
                        + "/screenshots/"
                        + testName + ".png"
        );

        try {
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved successfully");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
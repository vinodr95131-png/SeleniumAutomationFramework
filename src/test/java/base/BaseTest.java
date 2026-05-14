package base;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static ThreadLocal<WebDriver> tlDriver =
            new ThreadLocal<>();

    public WebDriver getDriver() {

        return tlDriver.get();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws IOException {
        ConfigReader configReader =
                new ConfigReader();

        if (browser.equalsIgnoreCase("chrome")) {

            tlDriver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("edge")) {

            tlDriver.set(new EdgeDriver());

        } else if (browser.equalsIgnoreCase("firefox")) {

            tlDriver.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        getDriver().get(configReader.getUrl());
    }

    @AfterMethod
    public void tearDown() {

        if (getDriver() != null) {

            getDriver().quit();

            tlDriver.remove();
        }
    }
}
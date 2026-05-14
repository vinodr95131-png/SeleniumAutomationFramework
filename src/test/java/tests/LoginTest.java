package tests;

import retry.RetryAnalyzer;
import base.BaseTest;
import dataproviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)

public class LoginTest extends BaseTest {

    @Test(
            retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "loginData",
            dataProviderClass = DataProviders.class
    )

    public void validLoginTest(String username,
                               String password) {

        LoginPage loginPage =
                new LoginPage(getDriver());

        loginPage.loginToApplication(
                username,
                password
        );
        String actualUrl =
                getDriver().getCurrentUrl();

        String expectedUrl =
                "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
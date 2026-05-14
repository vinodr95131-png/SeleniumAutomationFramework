package dataproviders;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        return ExcelUtility.getTestData("LoginData");
    }
}
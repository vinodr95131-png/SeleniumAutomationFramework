package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties properties;

    public ConfigReader() throws IOException {

        properties = new Properties();

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                        + "/src/test/resources/config.properties"
        );

        properties.load(fis);
    }

    public String getBrowser() {

        return properties.getProperty("browser");
    }

    public String getUrl() {

        return properties.getProperty("url");
    }

    public String getUsername() {

        return properties.getProperty("username");
    }

    public String getPassword() {

        return properties.getProperty("password");
    }
}
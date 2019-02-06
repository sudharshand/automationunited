package com.united.automation.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.PropertyConfigurator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserLaunch {
    static WebDriver driver;

    public static Properties loadPropertiesfile() throws IOException {
        String log4jConfPath = "./conf/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        Properties properties = new Properties();
        String propFileName = "application.properties";
        InputStream inputStream = MethodHandles.lookup().lookupClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        return properties;
    }

    public WebDriver signInApplication() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/charan/Documents/Java_projects/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  driver.get("https://www.unitedpetroleum.com.au");
        driver.get(loadPropertiesfile().getProperty("url"));
        return driver;
    }

}

package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getUserPassword();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
        driver = new ChromeDriver();
        logger = Logger.getLogger("e-banking");
        PropertyConfigurator.configure("log4j.properties");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

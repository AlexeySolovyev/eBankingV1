package com.inetbanking.testCases;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getUserPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {

        logger = Logger.getLogger("e-banking");
        PropertyConfigurator.configure("log4j.properties");

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String testName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomAddress() {
        return (RandomStringUtils.randomAlphanumeric(18));
    }

    public String randomCity() {
        return (RandomStringUtils.randomAlphabetic(9));
    }

    public String randomState() {
        return (RandomStringUtils.randomAlphabetic(8));
    }

    public String randomEmailAlias() {
        return (RandomStringUtils.randomAlphabetic(5));
    }

    public String randomPin() {
        return (RandomStringUtils.randomNumeric(6));
    }

    public String randomPhone() {
        return (RandomStringUtils.randomNumeric(10));
    }
}

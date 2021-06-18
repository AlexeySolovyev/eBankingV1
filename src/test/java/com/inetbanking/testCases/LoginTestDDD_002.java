package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;

public class LoginTestDDD_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDD(String user, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(user);
        logger.info("user name provided");
        loginPage.setPassword(password);
        logger.info("user password provided");
        Thread.sleep(3000);
        loginPage.clickSubmit();
        logger.info("Submit button has been clicked");

        if (isAlertPresent()) {
            driver.switchTo().alert().accept(); // close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.info("Login failed");
        } else {
            Assert.assertTrue(true);
            logger.info("Login passed");
            Thread.sleep(3000);
            loginPage.clickLogout();
            driver.switchTo().alert().accept(); // close logout alert
            driver.switchTo().defaultContent();
        }
    }

    public boolean isAlertPresent() {  // user defined method to check alert is present or not
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "Sheet1");
        int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

        String[][] loginData = new String[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return loginData;
    }
}

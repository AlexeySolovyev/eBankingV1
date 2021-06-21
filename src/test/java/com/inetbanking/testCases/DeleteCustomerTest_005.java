package com.inetbanking.testCases;

import com.inetbanking.pageObjects.DeleteCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class DeleteCustomerTest_005 extends BaseClass {

    @Test
    public void deleteCustomer() throws InterruptedException, IOException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();

        boolean isLoggedOn = driver.getPageSource().contains("Guru99 Bank");
        if (isLoggedOn) {
            Assert.assertTrue(true);
            logger.info("Successfully logged to the system");
        } else {
            logger.info("Authorisation is failed");
            captureScreen(driver, "loggOnProcedure");
            Assert.fail();
        }

        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.clickDeleteCustomerLink();
        deleteCustomerPage.setCustomerId("50135");
        deleteCustomerPage.clickIdSubmit();



    }
}

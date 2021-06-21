package com.inetbanking.testCases;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class EditCustomerTest_004 extends BaseClass {

    @Test
    public void editCustomer() throws InterruptedException, IOException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        logger.info("User name is provided");
        loginPage.setPassword(password);
        logger.info("User password is provided");
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
        EditCustomerPage editCustomer = new EditCustomerPage(driver);
        editCustomer.clickEditCustomerLink();
        editCustomer.setCustomerrId("50135");
        logger.info("Customer ID is provided");
        editCustomer.clickIdSubmit();

        boolean isValidId = driver.getPageSource().contains("Edit Customer");
        if (isValidId) {
            Assert.assertTrue(true);
            logger.info("Successfully validated CustomerID");
        } else {
            logger.info("Invalid Customer ID");
            captureScreen(driver, "submitCustomerID");
            Assert.fail();
        }
        logger.info("New Customer Data filling...");
        String address = randomAddress();
        editCustomer.setAddress(address);
        String city = randomCity();
        editCustomer.setCity(city);
        String state = randomState();
        editCustomer.setState(state);
        String pin = randomPin();
        editCustomer.setPIN(pin);
        String phone = randomPhone();
        editCustomer.setPhone(phone);
        String email = randomEmailAlias() + "@hotmail.net";
        editCustomer.setEmail(email);
        editCustomer.clickSubmit();

        Thread.sleep(1000);

        boolean isSuccess = driver.getPageSource().contains("Customer details updated Successfully!!!");
        if (isSuccess) {
            logger.info("Test case passed..");
            Assert.assertTrue(true);
        } else {
            logger.info("Test ");
            captureScreen(driver, "editCustomerProcedure");
        }
    }
}

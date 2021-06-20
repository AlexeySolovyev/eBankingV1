package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddCustomerTest_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        logger.info("User name is provided");
        loginPage.setPassword(password);
        logger.info("User password is provided");
        loginPage.clickSubmit();

        AddCustomerPage addCustomer = new AddCustomerPage(driver);
        addCustomer.clickNewCustomerLink();
        logger.info("Fill user details...");
        addCustomer.setUserName("TestUser");
        addCustomer.setGenderMale();
        addCustomer.setDoB("10", "12", "1987");
        addCustomer.setAddress("67 East st Manhattan NY USA");
        addCustomer.setCity("New York");
        addCustomer.setState("New York");
        addCustomer.setPIN("1234567");
        addCustomer.setPhone("9294098909");
        String email = randomEmailAlias() + "@testmail.org";
        addCustomer.setEmail(email);
        addCustomer.setPassword("qwerty12345");
        addCustomer.clickSubmit();

        Thread.sleep(1000);

        logger.info("Validation started...");
        boolean isSuccess = driver.getPageSource().contains("Customer Registered Successfully!!!");
        if (isSuccess) {
            Assert.assertTrue(true);
            logger.info("Test case passed...");
        } else {
            logger.info("Test case failed...");
            captureScreen(driver, "addNewCustomerProcedure");
            Assert.fail();
        }
    }
}

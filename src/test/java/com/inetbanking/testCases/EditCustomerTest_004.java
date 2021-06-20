package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.annotations.Test;
import java.io.IOException;

public class EditCustomerTest_004 extends BaseClass {

    @Test
    public void editCustomer() throws InterruptedException, IOException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();


    }
}

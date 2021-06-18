package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddCustomerTest_001 extends BaseClass {

    @Test
    public void addNewUser() throws IOException {
        driver.get(baseURL);
        LoginPage LoginPage = new LoginPage(driver);


    }
}

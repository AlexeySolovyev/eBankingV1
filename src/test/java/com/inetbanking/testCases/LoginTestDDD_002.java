package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestDDD_002 extends BaseClass{

    @Test(dataProvider = "LoginData")
    public void loginDDD(String user, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(user);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
    }

    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "Sheet1");
        int colCount = XLUtils.getCellCount(path,"Sheet1",1);

        String[][] loginData = new String[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return loginData;
    }
}

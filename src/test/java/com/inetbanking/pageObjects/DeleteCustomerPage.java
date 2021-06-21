package com.inetbanking.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

    WebDriver localDriver;
    public void deleteCustomerPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(xpath = "//a[@href='DeleteCustomerInput.php']")
    @CacheLookup
    WebElement linkDeleteCustomer;

    @FindBy(name = "cusid")
    @CacheLookup
    WebElement txtCustomerId;

    @FindBy(name = "AccSubmit")
    @CacheLookup
    WebElement btnCustomerSubmit;

    @FindBy(name = "res")
    @CacheLookup
    WebElement btnCustomerReset;

    public void clickDeleteCustomerLink() {
        linkDeleteCustomer.click();
    }

    public void setCustomerId(String customerId) {
        txtCustomerId.clear();
        txtCustomerId.sendKeys(customerId);
    }

    public void clickIdSubmit() {
        btnCustomerSubmit.click();
    }

    public void clickIdReset() {
        btnCustomerReset.click();
    }

    Alert alert;
    {
        assert false;
        alert = localDriver.switchTo().alert();
        alert.accept();
    }

}

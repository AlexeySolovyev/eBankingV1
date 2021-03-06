package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

    WebDriver localDriver;
    public EditCustomerPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(xpath = "//a[@href='EditCustomer.php']")
    @CacheLookup
    WebElement linkEditCustomer;

    @FindBy(name = "cusid")
    @CacheLookup
    WebElement txtCustomerID;

    @FindBy(name = "AccSubmit")
    @CacheLookup
    WebElement btnIdSubmit;

    @FindBy(name = "res")
    @CacheLookup
    WebElement btnIdReset;

    @FindBy(name = "addr")
    @CacheLookup
    WebElement txtAddress;

    @FindBy(name = "city")
    @CacheLookup
    WebElement txtCity;

    @FindBy(name = "state")
    @CacheLookup
    WebElement txtState;

    @FindBy(name = "pinno")
    @CacheLookup
    WebElement txtPIN;

    @FindBy(name = "telephoneno")
    @CacheLookup
    WebElement txtPhone;

    @FindBy(name = "emailid")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(name = "sub")
    @CacheLookup
    WebElement btnSubmit;

    @FindBy(name = "res")
    @CacheLookup
    WebElement btnReset;

    public void clickEditCustomerLink() {
        linkEditCustomer.click();
    }

    public void setCustomerrId (String customerId) {
        txtCustomerID.sendKeys(String.valueOf(customerId));
    }

    public void clickIdSubmit() {
        btnIdSubmit.click();
    }

    public void clickIdReset() {
        btnIdReset.click();
    }

    public void setAddress(String address) {
        txtAddress.clear();
        txtAddress.sendKeys(address);
    }

    public void setCity(String city) {
        txtCity.clear();
        txtCity.sendKeys(city);
    }

    public void setState(String state) {
        txtState.clear();
        txtState.sendKeys(state);
    }

    public void setPIN(String pin) {
        txtPIN.clear();
        txtPIN.sendKeys(String.valueOf(pin));
    }

    public void setPhone(String phone) {
        txtPhone.clear();
        txtPhone.sendKeys(phone);
    }

    public void setEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public void clickReset() {
        btnReset.click();
    }
}

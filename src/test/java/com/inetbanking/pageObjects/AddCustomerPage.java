package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    WebDriver localDriver;
    public AddCustomerPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement linkNewCustomer;

    @FindBy(name = "name")
    @CacheLookup
    WebElement txtName;

    @FindBy(how = How.CSS,using = "input[value='m']")
    @CacheLookup
    WebElement radioGenderMale;

    @FindBy(how = How.CSS, using = "input[value='f']")
    @CacheLookup
    WebElement radioGenderFemale;

    @FindBy(name = "dob")
    @CacheLookup
    WebElement txtDoB;

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

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "sub")
    @CacheLookup
    WebElement btnSubmit;

    @FindBy(name = "res")
    @CacheLookup
    WebElement btnReset;

    public void clickNewCustomerLink() {
        linkNewCustomer.click();
    }

    public void setName(String name) {
        txtName.sendKeys(name);
    }

    public void setGenderMale() {
        radioGenderMale.click();
    }

    public void setGenderFemale() {
        radioGenderFemale.click();
    }

    public void setDoB(String mm, String dd, String yy) {
        txtDoB.sendKeys(mm);
        txtDoB.sendKeys(dd);
        txtDoB.sendKeys(yy);

    }

    public void setAddress(String address) {
        txtAddress.sendKeys(address);
    }

    public void setCity(String city) {
        txtCity.sendKeys(city);
    }

    public void setState(String state) {
        txtState.sendKeys(state);
    }

    public void setPIN(String pin){
        txtPIN.sendKeys(pin);
    }

    public void setPhone(String phone) {
        txtPhone.sendKeys(phone);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public void clickReset() {
        btnReset.click();
    }

}

package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class Login extends BasePage {

    private final By username = By.xpath("//input[@data-qa='login-email']");
    private final By password = By.xpath("//input[@placeholder='Password']");
    private final By loginBtn = By.xpath("//button[normalize-space()='Login']");



    public Login(WebDriver driver){
        super(driver);
    }

    public Login enterUserNameInFld(String userid){
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(userid);
        return this;
    }

    public Login enterPasswordInFld(String pass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        return this;
    }

    public Dashboard clickOnLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return new Dashboard(driver);
    }


}

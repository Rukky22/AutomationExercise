package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class Product extends BasePage {

    public Product(WebDriver driver){
        super(driver);
    }

    private By addedalert = By.xpath("//h4[normalize-space()='Added!']");
    private By notificationaleart = By.xpath("//button[normalize-space()='Continue Shopping']");
    private By cartBtn = By.xpath("//u[normalize-space()='View Cart']");


    public Product addToCartBtn(String product){
        scrollIntoEle(driver.findElement(By.xpath("//p[contains(text(),'"+product+"')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'"+product+"')]")));
        hoverOnelement(driver.findElement(By.xpath("//p[contains(text(),'"+product+"')]")));
        WebElement element = driver.findElement(By.xpath("//p[text()='"+product+"']//parent::div[@class='overlay-content']//a"));
        js.executeScript("arguments[0].click()",element);
        return this;
    }

    public Product verifyAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedalert)).isDisplayed();
        return this;
    }

    public Product verifyNotification(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationaleart)).click();
        System.out.println("click continue shopping btn!!!");
        return this;
    }

    public CartPage clickOnCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBtn)).click();
        return new CartPage(driver);
    }



}

package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CheckOut extends BasePage {

    public CheckOut(WebDriver driver) {
        super(driver);
    }

    private final By comments = By.xpath("//textarea[@name='message']");
    private final By placeOrderBtn = By.xpath("//a[normalize-space()='Place Order']");


    public CheckOut enterComment(String comment){
        wait.until(ExpectedConditions.visibilityOfElementLocated(comments)).sendKeys(comment);
        return this;
    }

    public Payment clickPlaceOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderBtn)).click();
        return new Payment(driver);
    }


}

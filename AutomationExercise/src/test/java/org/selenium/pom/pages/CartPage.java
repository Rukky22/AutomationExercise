package org.selenium.pom.pages;

import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By checkOutBtn = By.xpath("//a[normalize-space()='Proceed To Checkout']");

    public CartPage verifyProduct(String product){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+product+"']")));
        return this;
    }

    public CartPage verifyPrice(String price){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. "+price+"']")));
        return this;
    }



    public CheckOut clickOnCheckout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutBtn)).click();
        return new CheckOut(driver);
    }


}

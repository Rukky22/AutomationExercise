package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.CreditCard;

public class Payment extends BasePage {

    public Payment(WebDriver driver){
        super(driver);
    }

    private final By cardname = By.xpath("//input[@name='name_on_card']");
    private final By cardnumber = By.xpath("//input[@name='card_number']");
    private final By cvv = By.xpath("//input[@placeholder='ex. 311']");
    private final By expirationmonth = By.xpath("//input[@placeholder='MM']");
    private final By expirationyear = By.xpath("//input[@placeholder='YYYY']");
    private final By confirmOrderBtn = By.xpath("//button[@id='submit']");
    private final By confirmOrder = By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']");

    public Payment enterCardDetailsandverifyConfirmMessage(CreditCard creditCard){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardname)).sendKeys(creditCard.getCardName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardnumber)).sendKeys(creditCard.getCardNumber());
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvv)).sendKeys(creditCard.getExpiration());
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirationmonth)).sendKeys(creditCard.getMonth());
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirationyear)).sendKeys(creditCard.getYear());
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder)).isDisplayed();
        return this;
    }


}

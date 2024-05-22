package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePage extends BasePage {

    private final By homePageHeader = By.xpath("//img[@alt='Website for automation practice']");
    private final By signupAndLoginBtn = By.xpath("//a[normalize-space()='Signup / Login']");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage load(){
        load("");
        return this;
    }

    public HomePage closeCurWindow() throws InterruptedException {
        String window = "adblockultimate";
        Set<String> windows = driver.getWindowHandles();

        List<String> new_windows = new ArrayList<>(windows);

        for (String switchto : new_windows) {
            String cur = driver.switchTo().window(switchto).getCurrentUrl();
            System.out.println(cur);

            if (cur.contains(window)) {
                System.out.println("Found the window");
//                driver.findElement(By.xpath("//span[text()='Home']")).click();
                System.out.println(driver.getCurrentUrl());
                driver.close();
                break;
            }
        }
        driver.switchTo().window(new_windows.get(0));
        return this;
    }

    public WebElement logo(){
        return driver.findElement(homePageHeader);
    }

    public HomePage verifyTitle(){
        wait.until(ExpectedConditions.visibilityOf(logo()));
        return this;
    }

    public Login navigateToLoginPageUsingLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(signupAndLoginBtn)).click();
        return new Login(driver);
    }

}

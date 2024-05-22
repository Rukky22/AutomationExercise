package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser){
        if (browser == null) {
            browser = "CHROME";
        }
        setDriver(new DriverManager().initializeDriver(browser));
        System.out.println("CURRENT THREAD "+ Thread.currentThread().getId() + " ,"+ getDriver());
    }

    @AfterMethod
    public void quitDriver(){
        System.out.println("CURRENT THREAD "+ Thread.currentThread().getId() + " , "+ getDriver());
        getDriver().quit();
    }
}
package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);

    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    public void waitForTheOverlaysDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("Overlays Size"+ overlays.size());
        if (overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays)
            );
            System.out.println("Overlays is invisible ");
        } else {
            System.out.println("Overlays not found ");
        }
    }

    public void hoverOnelement(WebElement ele){
        actions.moveToElement(ele).perform();
    }

    public void scrollIntoEle(WebElement elm){
        js.executeScript("arguments[0].scrollIntoView(true);", elm);
    }
}

package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.FakerUtils;
import org.w3c.dom.CDATASection;

import java.util.*;

public class Dashboard extends BasePage {

    public Dashboard(WebDriver driver){
        super(driver);
    }

    private final By priceListOnFeaturePage =By.xpath("//div[@class='features_items']//following-sibling::div[@class='productinfo text-center']/h2");
    private final By labelOnFeaturePage = By.xpath("//div[@class='features_items']//following-sibling::div[@class='productinfo text-center']/p");
    private final By womenCategory = By.xpath("//a[normalize-space()='Women']");
    private final By topsSubcategory = By.xpath("//div[@id='Women']//li[2]/a");

    public Dashboard fetchPriceOfFeatureItems(){
        Map<Integer,String> unSortedPriceOfFeatureList = new HashMap<>();
        List<WebElement> pricesOfItems = wait.until(ExpectedConditions.visibilityOfElementLocated(priceListOnFeaturePage)).findElements(priceListOnFeaturePage);
        List<WebElement> labelOfItems = wait.until(ExpectedConditions.visibilityOfElementLocated(labelOnFeaturePage)).findElements(labelOnFeaturePage);

        for (int i = 0; i < pricesOfItems.size(); i++) {
            while (i < labelOfItems.size()) {
                unSortedPriceOfFeatureList.put(FakerUtils.extractIntegerPart(pricesOfItems.get(i).getText()),labelOfItems.get(i).getText());
                break;
            }
        }

        Map<Integer, String> sortedMap = new TreeMap<>(unSortedPriceOfFeatureList);

        for (Map.Entry o: sortedMap.entrySet()) {
            System.out.println(o.getKey()+" "+o.getValue());
        }
        return this;
    }

    public Product clickOnTopsUsingWomensCategory(){
        scrollIntoEle(driver.findElement(womenCategory));
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenCategory)).click();
        scrollIntoEle(driver.findElement(topsSubcategory));
        wait.until(ExpectedConditions.visibilityOfElementLocated(topsSubcategory)).click();
        return new Product(driver);
    }

}

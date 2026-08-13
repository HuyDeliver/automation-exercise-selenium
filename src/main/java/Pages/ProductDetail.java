package Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetail {
    private WebDriver driver;

    public ProductDetail(WebDriver driver) {
        this.driver = driver;
    }

    // product name, category, price, availability, condition, brand
    private By productName = By.xpath("//div[contains(@class,'product-information')]/h2");
    private By productCategory = By
            .xpath("//div[contains(@class,'product-information')]/p[contains(text(),'Category')]");
    private By productPrice = By.xpath("//div[contains(@class,'product-information')]//span");
    private By productAvailability = By
            .xpath("//div[contains(@class,'product-information')]/p[b[contains(text(),'Availability:')]]");
    private By productCondition = By
            .xpath("//div[contains(@class,'product-information')]/p[b[contains(text(),'Condition:')]]");
    private By productBrand = By
            .xpath("//div[contains(@class,'product-information')]/p[b[contains(text(),'Brand:')]]");

    public boolean isproductNameVisible() {
        return driver.findElement(productName).isDisplayed();
    }

    public boolean isproductCategoryVisible() {
        return driver.findElement(productCategory).isDisplayed();
    }

    public boolean isproductPriceVisible() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean isproductAvailabilityVisible() {
        return driver.findElement(productAvailability).isDisplayed();
    }

    public boolean isproductConditionVisible() {
        return driver.findElement(productCondition).isDisplayed();
    }

    public boolean isproductBrandVisible() {
        return driver.findElement(productBrand).isDisplayed();
    }
}

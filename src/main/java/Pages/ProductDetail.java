package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.waitUtilities;

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
    private By productQuantity = By.id("quantity");

    private By buttonAddCart = By.cssSelector("button.btn.btn-default.cart");

    private By cartModal = By.id("cartModal");

    private By viewCartButton = By.xpath(".//div[contains(@class, 'modal-body')]//a[u[text() = 'View Cart']]");

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

    public void increaseQuantity(String index) {
        WebElement increase = driver.findElement(productQuantity);
        increase.clear();
        increase.sendKeys(index + Keys.TAB);
    }

    public void addToCart() {
        driver.findElement(buttonAddCart).click();
    }

    public CartPage viewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartModal));
        waitUtilities.waitClickElement(driver, viewCartButton);
        return new CartPage(driver);
    }

}

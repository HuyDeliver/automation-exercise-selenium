package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.waitUtilities;

public class BrandProductPage {
    private WebDriver driver;

    public BrandProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By product = By.cssSelector(".features_items .col-sm-4");

    public boolean verifyUrlBrand(String brandname) {
        return waitUtilities.verifyUrl(driver, "https://automationexercise.com/brand_products/" + brandname + "");
    }

    public boolean verifyProduct() {
        List<WebElement> products = driver.findElements(product);
        return !products.isEmpty() && products.get(0).isDisplayed();
    }

    public void clickProduct(String brandName) {
        By click = By.xpath("//div[@class='brands-name']/ul/li/a[contains(normalize-space(.), '" + brandName + "')]");
        waitUtilities.waitClickElement(driver, click);
    }

}

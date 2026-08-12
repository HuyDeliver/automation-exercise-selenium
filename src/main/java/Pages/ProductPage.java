package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.helpers.Util;

import Utils.Utils;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productItem = By
            .xpath("//div[contains(@class,'features_items')]//div[contains(@class, 'product-image-wrapper')]");

    private By viewProduct = By.xpath("//a[contains(text(),'View Product')]");

    public boolean isProductListVisible() {
        return !driver.findElements(productItem).isEmpty();
    }

    public ProductDetail redirectProductDetail() {
        Utils.waitClickElement(driver, viewProduct);
        return new ProductDetail(driver);
    }
}

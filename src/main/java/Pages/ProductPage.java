package Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.Utils;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productItem = By
            .xpath("//div[contains(@class,'features_items')]//div[contains(@class, 'product-image-wrapper')]");

    private By viewProduct = By.xpath("(//a[contains(text(),'View Product')])[10]");

    private By searchInput = By.xpath("//input[@name='search' and @id='search_product']");

    private By searchButton = By.xpath("//button[@id='submit_search']");

    private By productName = By.xpath(
            "//div[contains(@class,'single-products')]/div[contains(@class,'productinfo')]/p");

    public boolean isProductListVisible() {
        return !driver.findElements(productItem).isEmpty();
    }

    public ProductDetail redirectProductDetail() {
        Utils.scrollWindow(driver, 0, 300);
        Utils.waitClickElement(driver, viewProduct);
        return new ProductDetail(driver);
    }

    public boolean isLandedToProductPage() {
        return Utils.verifyUrl(driver, "https://automationexercise.com/product_details");
    }

    public void searchProduct(String nameproduct) {
        driver.findElement(searchInput).sendKeys(nameproduct);
        driver.findElement(searchButton).click();
    }

    public boolean isTitleSearchVisible() {
        return "Search Product".equals(driver.findElement(searchInput).getAttribute("placeholder"));
    }

    public List<String> isAllProductSearchedVisible() {
        return driver.findElements(productName).stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
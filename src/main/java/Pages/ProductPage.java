package Pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.waitUtilities;

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

    private By hoverProduct = By.cssSelector(".single-products");

    private By continueShopping = By.xpath("//button[contains(@class,'close-modal') and text()='Continue Shopping']");

    private By viewCartButton = By.xpath("//div[contains(@class, 'modal-body')]//a[u[text() = 'View Cart']]");

    private By cartModal = By.id("cartModal");

    private By brandTitle = By.cssSelector(".left-sidebar .brands_products>h2");

    private By brandName = By.cssSelector(".brands-name .nav>ul>li>a");

    public boolean isProductListVisible() {
        return !driver.findElements(productItem).isEmpty();
    }

    public ProductDetail redirectProductDetail() {
        waitUtilities.scrollWindow(driver, 0, 300);
        waitUtilities.waitClickElement(driver, viewProduct);
        return new ProductDetail(driver);
    }

    public boolean isLandedToProductPage() {
        return waitUtilities.verifyUrl(driver, "https://automationexercise.com/product_details");
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

    public void addToCart(int index) {
        WebElement hover = driver.findElements(hoverProduct).get(index);
        new Actions(driver)
                .scrollToElement(hover)
                .moveToElement(hover)
                .perform();
        WebElement addCart = hover.findElement(
                By.xpath(".//a[contains(@class,'add-to-cart')]"));
        waitUtilities.waitClickElementforList(driver, addCart);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartModal));
    }

    public void continueShopping() {
        waitUtilities.waitClickElement(driver, continueShopping);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cartModal));
    }

    public CartPage viewCart() {
        waitUtilities.waitClickElement(driver, viewCartButton);
        return new CartPage(driver);
    }

    public boolean isBrandInSideBar() {
        return !driver.findElements(brandTitle).isEmpty();
    }

    public BrandProductPage viewBrand() {
        waitUtilities.waitClickElement(driver, brandName);
        return new BrandProductPage(driver);
    }

}
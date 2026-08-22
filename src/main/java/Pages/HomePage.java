package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.waitUtilities;

public class HomePage {
    private WebDriver driver;

    private By signupLoginButton = By.linkText("Signup / Login");

    private By textLogin = By.xpath("//a[contains(text(),'Logged in as')]");

    private By textDelete = By.xpath("//a[contains(text(),'Delete Account')]");

    private By logOut = By.xpath("//a[contains(text(),'Logout')]");

    private By clickContact = By.xpath("//a[contains(text(),'Contact us')]");

    private By clickTestCase = By.xpath("//a[contains(text(),'Test Cases')]");

    private By clickProduct = By.xpath("//a[contains(text(),'Products')]");

    private By clickCart = By.xpath("//a[contains(text(),' Cart')]");

    private By viewProduct = By.xpath("(//a[contains(text(),'View Product')])");

    private By hoverProduct = By.cssSelector(".single-products");
    private By continueShopping = By.cssSelector("button.btn.btn-success.close-modal.btn-block");

    private By cartModal = By.id("cartModal");

    private By categoryTitle = By.cssSelector(".left-sidebar>h2");

    private By womenCategory = By
            .xpath("//div[@class='panel-heading']//a[contains(normalize-space(.), 'Women') and @href='#Women']");

    private By panelCategory = By.cssSelector(".panel-body>ul>li>a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public LoginSignupPage clickSignupLogin() {
        waitUtilities.waitClickElement(driver, signupLoginButton);
        return new LoginSignupPage(driver);
    }

    public boolean isUserLogin() {
        return !driver.findElements(textLogin).isEmpty();
    }

    public DeleteAccount deleteAccount() {
        driver.findElement(textDelete).click();
        return new DeleteAccount(driver);
    }

    public boolean isNavitoLoginPage() {
        return waitUtilities.verifyUrl(driver, "https://automationexercise.com/login");
    }

    public LoginSignupPage logOut() {
        driver.findElement(logOut).click();
        return new LoginSignupPage(driver);
    }

    public ContactForm contactUs() {
        driver.findElement(clickContact).click();
        return new ContactForm(driver);
    }

    public void clickTestCasePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(clickTestCase)).click();
    }

    public boolean isNavitoTestCasePage() {
        return waitUtilities.verifyUrl(driver, "https://automationexercise.com/test_cases");
    }

    public ProductPage clickProduct() {
        waitUtilities.waitClickElement(driver, clickProduct);
        return new ProductPage(driver);
    }

    public boolean isNavitoProductPage() {
        return waitUtilities.verifyUrl(driver, "https://automationexercise.com/products");
    }

    public CartPage RedirectToCartPage() {
        waitUtilities.waitClickElement(driver, clickCart);
        return new CartPage(driver);
    }

    public ProductDetail redirectProductDetail() {
        waitUtilities.scrollWindow(driver, 0, 300);
        waitUtilities.waitClickElement(driver, viewProduct);
        return new ProductDetail(driver);
    }

    public boolean isLandedToProductDetail() {
        return waitUtilities.verifyUrl(driver, "https://automationexercise.com/product_details");
    }

    public boolean isLandedtoCartPage() {
        return waitUtilities.verifyUrl(driver, "https://automationexercise.com/view_cart");
    }

    public void addToCart() {
        WebElement hover = driver.findElement(hoverProduct);
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

    public boolean verifySidebar() {
        return !driver.findElements(categoryTitle).isEmpty();
    }

    public void womenCategoryClick() {
        waitUtilities.waitClickElement(driver, womenCategory);
    }

    public CategoryPage goTocategoryProduct() {
        waitUtilities.waitClickElement(driver, panelCategory);
        return new CategoryPage(driver);
    }

}
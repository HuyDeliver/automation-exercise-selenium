package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Utils;

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

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public LoginSignupPage clickSignupLogin() {
        Utils.waitClickElement(driver, signupLoginButton);
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
        return Utils.verifyUrl(driver, "https://automationexercise.com/login");
    }

    public LoginSignupPage logOut() {
        driver.findElement(logOut).click();
        return new LoginSignupPage(driver);
    }

    public ContactForm contactUs() {
        driver.findElement(clickContact).click();
        return new ContactForm(driver);
    }

    public TestCasePage clickTestCasePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(clickTestCase)).click();
        return new TestCasePage(driver);
    }

    public boolean isNavitoTestCasePage() {
        return Utils.verifyUrl(driver, "https://automationexercise.com/test_cases");
    }

    public ProductPage clickProduct() {
        Utils.waitClickElement(driver, clickProduct);
        return new ProductPage(driver);
    }

    public boolean isNavitoProductPage() {
        return Utils.verifyUrl(driver, "https://automationexercise.com/products");
    }

    public CartPage RedirectToCartPage() {
        Utils.waitClickElement(driver, clickCart);
        return new CartPage(driver);
    }
}
package Pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.waitUtilities;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameProduct = By.cssSelector(".cart_description>h4>a");

    private By quantityProduct = By.cssSelector("button.disabled");

    private By CheckOut = By.cssSelector(".btn.btn-default.check_out");

    private By registerLogin = By.xpath("//a[u[text()='Register / Login']]");

    private By deleteProduct = By.cssSelector(".cart_quantity_delete");

    public List<String> verifyProduct() {
        return driver.findElements(nameProduct).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean verifyQuantity(String index) {
        return driver.findElement(quantityProduct).getText().equals(index);
    }

    public CheckoutPage procceedCheckout() {
        waitUtilities.waitClickElement(driver, CheckOut);
        return new CheckoutPage(driver);
    }

    public LoginSignupPage redirLoginSignupPage() {
        waitUtilities.waitClickElement(driver, registerLogin);
        return new LoginSignupPage(driver);
    }

    public void deleteProduct() {
        waitUtilities.waitClickElement(driver, deleteProduct);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(nameProduct));
    }

}

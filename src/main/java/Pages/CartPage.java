package Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.Utils;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameProduct = By.cssSelector(".cart_description>h4>a");

    private By quantityProduct = By.cssSelector("button.disabled");

    private By CheckOut = By.cssSelector(".btn.btn-default.check_out");

    private By registerLogin = By.xpath("//a[u[text()='Register / Login']]");

    public List<String> verifyProduct() {
        return driver.findElements(nameProduct).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean verifyQuantity(String index) {
        return driver.findElement(quantityProduct).getText().equals(index);
    }

    public CheckoutPage procceedCheckout() {
        Utils.waitClickElement(driver, CheckOut);
        return new CheckoutPage(driver);
    }

    public LoginSignupPage redirLoginSignupPage() {
        Utils.waitClickElement(driver, registerLogin);
        return new LoginSignupPage(driver);
    }

}

package Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameProduct = By.cssSelector(".cart_description>h4>a");

    private By quantityProduct = By.cssSelector("button.disabled");

    public List<String> verifyProduct() {
        return driver.findElements(nameProduct).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean verifyQuantity(String index) {
        return driver.findElement(quantityProduct).getText().equals(index);
    }

}

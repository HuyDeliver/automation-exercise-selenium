package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.UserData;
import Utils.Utils;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameCard = By.name("name_on_card");
    private By numberCard = By.cssSelector("input.form-control.card-number");
    private By CVC = By.cssSelector("input.form-control.card-cvc");
    private By expirationMonth = By.cssSelector("input.form-control.card-expiry-month");
    private By expirationYear = By.cssSelector("input.form-control.card-expiry-year");

    private By payButton = By.cssSelector("button.form-control.btn.btn-primary.submit-button");
    private By confirmOrder = By.cssSelector(".alert-success.alert");

    public void fillInfoCard(UserData card) {
        driver.findElement(nameCard).sendKeys(card.getNameCard());
        driver.findElement(numberCard).sendKeys(card.getNumberCard());
        driver.findElement(CVC).sendKeys(card.getCVC());
        driver.findElement(expirationMonth).sendKeys(card.getMonthExpiration());
        driver.findElement(expirationYear).sendKeys(card.getYearExpiration());
    }

    public void payOrder() {
        Utils.waitClickElement(driver, payButton);
    }

    public boolean isOrderPlaceSuccess() {
        return !driver.findElements(confirmOrder).isEmpty();
    }
}

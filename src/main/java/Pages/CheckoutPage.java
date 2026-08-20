package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.waitUtilities;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameOrder = By.cssSelector("li.address_firstname.address_lastname");
    private By companyOrder = By.xpath(
            ".//ul[contains(@id, 'address_delivery')]/li[3]");
    private By addressOrder1 = By.xpath(
            ".//ul[contains(@id, 'address_delivery')]/li[4]");
    private By cityOrder = By.xpath(
            ".//ul[contains(@id, 'address_delivery')]/li[6]");
    private By countryOrder = By.xpath(
            ".//ul[contains(@id, 'address_delivery')]/li[7]");
    private By phoneOrder = By.xpath(
            ".//ul[contains(@id, 'address_delivery')]/li[8]");

    private By textMessage = By.xpath(".//div[@id='ordermsg']/textarea");
    private By placeOrderButton = By.cssSelector("a.btn.btn-default.check_out");

    public boolean isNameOrderRight(String actualName) {
        return driver.findElement(nameOrder).getText().contains(actualName);
    }

    public boolean isCompanyOrder(String company) {
        return driver.findElement(companyOrder).getText().contains(company);
    }

    public boolean isCityOrder(String city) {
        return driver.findElement(cityOrder).getText().contains(city);
    }

    public boolean isCountryOrder(String country) {
        return driver.findElement(countryOrder).getText().contains(country);
    }

    public boolean isAddressOrder1(String address1) {
        return driver.findElement(addressOrder1).getText().contains(address1);
    }

    public boolean isPhoneOrder(String phone) {
        return driver.findElement(phoneOrder).getText().contains(phone);
    }

    public PaymentPage placeOrder(String message) {
        driver.findElement(textMessage).sendKeys(message);
        waitUtilities.waitClickElement(driver, placeOrderButton);
        return new PaymentPage(driver);
    }
}
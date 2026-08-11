package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccount {
    private WebDriver driver;

    public DeleteAccount(WebDriver driver) {
        this.driver = driver;
    }

    private By textAccountDelete = By.xpath("//b[text()='Account Deleted!']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public boolean isAccountDelete() {
        return !driver.findElements(textAccountDelete).isEmpty();
    }

    public HomePage redirectAfterDelete() {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }

}

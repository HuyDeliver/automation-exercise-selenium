package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountSuccess {
    WebDriver driver;

    public CreateAccountSuccess(WebDriver driver) {
        this.driver = driver;
    }

    private By verifyNote = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public boolean isAccountCeated() {
        return !driver.findElements(verifyNote).isEmpty();
    }

    public HomePage redirectAfterCreate() {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}

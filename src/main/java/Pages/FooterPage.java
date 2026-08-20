package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.waitUtilities;

public class FooterPage {
    private WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleSubcription = By.xpath("//h2[text()='Subscription']");

    private By subcripEmail = By.xpath("//input[@id='susbscribe_email']");

    private By subcripButton = By.xpath("//button[@id='subscribe']");

    private By subcripSuccess = By
            .xpath("//div[text()='You have been successfully subscribed!']");

    public boolean isSubcriptionVisible() {
        waitUtilities.ScrolltoView(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleSubcription)).isDisplayed();
    }

    public void subcription(String email) {
        driver.findElement(subcripEmail).sendKeys(email);
        waitUtilities.waitClickElement(driver, subcripButton);
    }

    public boolean isSubcripAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subcripSuccess)).isDisplayed();
    }
}

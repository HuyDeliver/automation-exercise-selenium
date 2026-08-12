package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactForm {
    private WebDriver driver;

    public ContactForm(WebDriver driver) {
        this.driver = driver;
    }

    private By contactName = By.xpath("//input[@data-qa='name']");
    private By contacEmail = By.xpath("//input[@data-qa='email']");
    private By contacSubject = By.xpath("//input[@data-qa='subject']");
    private By contacMessage = By.xpath("//textarea[@data-qa='message']");
    private By contacFile = By.xpath("//input[@type='file']");
    private By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private By titleContact = By.xpath("//h2[text()='Get In Touch']");
    private By submitContactSuccess = By
            .xpath("//div[text()='Success! Your details have been submitted successfully.']");
    private By buttonHome = By.xpath("//a/span[contains(text(),'Home')]");

    public void getInTouch(String name, String email, String subject, String message, String file) {
        driver.findElement(contactName).sendKeys(name);
        driver.findElement(contacEmail).sendKeys(email);
        driver.findElement(contacSubject).sendKeys(subject);
        driver.findElement(contacMessage).sendKeys(message);
        driver.findElement(contacFile).sendKeys(file);
        driver.findElement(submitButton).click();
    }

    public ContactForm contactConfirm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }

    public HomePage redirectHomePage() {
        driver.findElement(buttonHome).click();
        return new HomePage(driver);
    }

    public boolean isNavitoHomePage(String currentUrl) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.urlContains(currentUrl));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTitleContactShow() {
        return !driver.findElements(titleContact).isEmpty();
    }

    public boolean isConfirmContactSuccess() {
        return !driver.findElements(submitContactSuccess).isEmpty();
    }
}

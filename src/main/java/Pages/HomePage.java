package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    private By signupLoginButton = By.linkText("Signup / Login");

    private By textLogin = By.xpath("//a[contains(text(),'Logged in as')]");

    private By textDelete = By.xpath("//a[contains(text(),'Delete Account')]");

    private By logOut = By.xpath("//a[contains(text(),'Logout')]");

    private By clickContact = By.xpath("//a[contains(text(),'Contact us')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public LoginSignupPage clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
        return new LoginSignupPage(driver);
    }

    public boolean isUserLogin() {
        return !driver.findElements(textLogin).isEmpty();
    }

    public DeleteAccount deleteAccount() {
        driver.findElement(textDelete).click();
        return new DeleteAccount(driver);
    }

    public boolean isNavitoLoginPage(String currentUrl) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.urlToBe(currentUrl));
        } catch (Exception e) {
            return false;
        }
    }

    public LoginSignupPage logOut() {
        driver.findElement(logOut).click();
        return new LoginSignupPage(driver);
    }

    public ContactForm contactUs() {
        driver.findElement(clickContact).click();
        return new ContactForm(driver);
    }
}
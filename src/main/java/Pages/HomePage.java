package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    private final By signupLoginButton = By.linkText("Signup / Login");

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
}
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By signupLoginButton = By.linkText("Signup / Login");

    private By textLogin = By.xpath("//a[contains(text(),'Logged in as')]");

    private By textDelete = By.xpath("//a[contains(text(),'Delete Account')]");

    private By logOut = By.xpath("//a[contains(text(),'Logout')]");

    private String urlWeb;

    // String urlWeb = driver.getCurrentUrl();

    // Assert.assertEquals(urlWeb, "https://automationexercise.com/login");
    // }
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
        return currentUrl.equalsIgnoreCase("https://automationexercise.com/login");
    }

    public LoginSignupPage logOut() {
        driver.findElement(logOut).click();
        return new LoginSignupPage(driver);
    }
}
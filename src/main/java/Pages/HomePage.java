package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By signupLoginButton = By.linkText("Signup / Login");

    private By textLogin = By.xpath("//a[contains(text(),'Logged in as')]");

    private By textDelete = By.xpath("//a[contains(text(),'Delete Account')]");

    // WebElement textLogin =
    // driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));

    // Assert.assertEquals(textLogin.getText(), "Logged in as Huydeliver");

    // WebElement textDelete =
    // driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

    // textDelete.click();
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
}
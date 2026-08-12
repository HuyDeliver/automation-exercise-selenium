package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {
    private WebDriver driver;

    // Signup form
    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By newUserSignupTitle = By.xpath("//h2[text()='New User Signup!']");
    private By signupFail = By.xpath("//p[text()='Email Address already exist!']");

    // Login form (nếu sau này bạn cần)
    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By loginTitle = By.xpath("//h2[text()='Login to your account']");
    private By loginFail = By.xpath("//p[text()='Your email or password is incorrect!']");

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewUserSignupVisible() {
        return !driver.findElements(newUserSignupTitle).isEmpty();
    }

    public boolean isLoginFormVisible() {
        return !driver.findElements(loginTitle).isEmpty();
    }

    public boolean isLoginFail() {
        return !driver.findElements(loginFail).isEmpty();
    }

    public boolean isSignupFail() {
        return !driver.findElements(signupFail).isEmpty();
    }

    public EnterAccountInfoPage signup(String name, String email) {
        driver.findElement(signupName).clear();
        driver.findElement(signupName).sendKeys(name);

        driver.findElement(signupEmail).clear();
        driver.findElement(signupEmail).sendKeys(email);

        driver.findElement(signupButton).click();
        return new EnterAccountInfoPage(driver);
    }

    public HomePage login(String email, String password) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

}
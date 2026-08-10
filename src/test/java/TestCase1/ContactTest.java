package TestCase1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest {
    WebDriver driver;

    // @BeforeMethod
    // public void setUp() {
    // ChromeOptions options = new ChromeOptions();

    // // Chặn quảng cáo Google
    // options.addArguments(
    // "--host-resolver-rules=MAP googleads.g.doubleclick.net 127.0.0.1, MAP
    // pagead2.googlesyndication.com 127.0.0.1, MAP adservice.google.com
    // 127.0.0.1");

    // // Không đợi load hết tất cả (bỏ qua ads, tracking, ...)
    // options.setPageLoadStrategy(PageLoadStrategy.EAGER);

    // // Tắt notification, popup
    // options.addArguments("--disable-notifications");
    // options.addArguments("--disable-popup-blocking");

    // driver = new ChromeDriver(options);

    // driver.manage().window().maximize();

    // driver.get("https://automationexercise.com/");

    // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    // }

    // @Test
    // public void LoginUser() {
    // verifyClickonsignup();
    // Login();
    // }

    // public void verifyClickonsignup() {
    // // Click on 'Signup / Login' button and Verify 'New User Signup!' is visible
    // WebElement signupbutton = driver.findElement(By.linkText("Signup / Login"));

    // signupbutton.click();

    // WebElement titleSignup = driver.findElement(By.xpath("//h2[text()='New User
    // Signup!']"));
    // Assert.assertEquals(titleSignup.getText(), "New User Signup!");

    // }

    // public void Login() {
    // WebElement emailLogin =
    // driver.findElement(By.xpath("//input[@data-qa='login-email']"));
    // emailLogin.sendKeys("Stunanguyen@gmail.com");

    // WebElement passwordLogin =
    // driver.findElement(By.xpath("//input[@data-qa='login-password']"));
    // passwordLogin.sendKeys("18042004");

    // WebElement buttonLogin = driver.findElement(By.xpath("//button[text()='Login'
    // and @type='submit']"));
    // buttonLogin.click();

    // WebElement textLogin =
    // driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));

    // Assert.assertEquals(textLogin.getText(), "Logged in as Huydeliver");

    // WebElement textDelete =
    // driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

    // textDelete.click();

    // String urlWeb = driver.getCurrentUrl();

    // Assert.assertEquals(urlWeb, "https://automationexercise.com/login");
    // }

    // @AfterMethod
    // public void endRegister() throws InterruptedException {
    // Thread.sleep(5000);
    // driver.quit();
    // }
}

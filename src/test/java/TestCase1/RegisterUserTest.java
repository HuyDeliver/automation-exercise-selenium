package TestCase1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTest {

    // WebDriver driver;

    // @BeforeMethod
    // public void setUp() {
    // ChromeOptions options = new ChromeOptions();

    // // Chặn quảng cáo Google
    // options.addArguments(
    // "--host-resolver-rules=MAP googleads.g.doubleclick.net 127.0.0.1, MAP
    // pagead2.googlesyndication.com 127.0.0.1, MAP adservice.google.com
    // 127.0.0.1");

    // driver = new ChromeDriver(options);

    // driver.manage().window().maximize();

    // driver.get("https://automationexercise.com/");

    // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // }

    // @Test
    // public void userRegister() {
    // verifyHompage();
    // verifyClickonsignup();
    // EnterInfoSignup();
    // enterAccountInfo();
    // enterAdressInformation();
    // }

    // public void verifyHompage() {
    // // Verify that home page is visible successfully
    // String title = driver.getTitle();
    // Assert.assertEquals(title, "Automation Exercise");
    // }

    // public void verifyClickonsignup() {
    // // Click on 'Signup / Login' button and Verify 'New User Signup!' is visible
    // WebElement signupbutton = driver.findElement(By.linkText("Signup / Login"));

    // signupbutton.click();

    // WebElement titleSignup = driver.findElement(By.xpath("//h2[text()='New User
    // Signup!']"));
    // Assert.assertEquals(titleSignup.getText(), "New User Signup!");

    // }

    // public void EnterInfoSignup() {
    // // Enter name and email address and Click 'Signup' button and Verify that
    // 'ENTER
    // // ACCOUNT INFORMATION' is visible

    // WebElement signupname =
    // driver.findElement(By.xpath("//input[@data-qa='signup-name']"));

    // signupname.sendKeys("HuyDeliver");

    // WebElement signupemail =
    // driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

    // signupemail.sendKeys("Ariana@gmail.com");

    // WebElement signupClick =
    // driver.findElement(By.xpath("//button[text()='Signup' and @type='submit']"));

    // signupClick.click();

    // WebElement titleEnterAccount = driver.findElement(By.xpath("//b[text()='Enter
    // Account Information']"));

    // Assert.assertEquals(titleEnterAccount.getText().toUpperCase(), "ENTER ACCOUNT
    // INFORMATION");
    // }

    // public void enterAccountInfo() {
    // WebElement chooseTitle = driver.findElement(By.id("id_gender1"));
    // chooseTitle.click();

    // WebElement typeName = driver.findElement(By.id("name"));
    // WebElement typeEmail = driver.findElement(By.id("email"));
    // String actualName = typeName.getAttribute("value");
    // String actualEmail = typeEmail.getAttribute("value");
    // Assert.assertEquals(actualName, "HuyDeliver");
    // Assert.assertEquals(actualEmail, "Ariana@gmail.com");

    // WebElement typePassword = driver.findElement(By.id("password"));
    // typePassword.sendKeys("18042004");

    // // Select date of birth
    // Select chooseday = new Select(driver.findElement(By.name("days")));
    // chooseday.selectByVisibleText("18");
    // Select chooseMonth = new Select(driver.findElement(By.name("months")));
    // chooseMonth.selectByVisibleText("April");
    // Select chooseYear = new Select(driver.findElement(By.name("years")));
    // chooseYear.selectByVisibleText("2004");

    // // Choose option
    // WebElement chooseletter = driver.findElement(By.id("newsletter"));
    // chooseletter.click();
    // WebElement chooseoptin = driver.findElement(By.id("optin"));
    // chooseoptin.click();
    // }

    // public void enterAdressInformation() {
    // WebElement typeFirstName = driver.findElement(By.id("first_name"));
    // typeFirstName.sendKeys("Huy");

    // WebElement typeLastName = driver.findElement(By.id("last_name"));
    // typeLastName.sendKeys("Deliver");

    // WebElement typeCompany = driver.findElement(By.id("company"));
    // typeCompany.sendKeys("BKT");

    // WebElement typeAddress1 = driver.findElement(By.id("address1"));
    // typeAddress1.sendKeys("Thanh hóa");

    // WebElement typeAddress2 = driver.findElement(By.id("address2"));
    // typeAddress2.sendKeys("Hà Nội");

    // Select chooseCountry = new Select(driver.findElement(By.name("country")));
    // chooseCountry.selectByVisibleText("Israel");

    // WebElement typeState = driver.findElement(By.id("state"));
    // typeState.sendKeys("unemployment");

    // WebElement typeCity = driver.findElement(By.id("city"));
    // typeCity.sendKeys("Thanh hóa");

    // WebElement typeZipcode = driver.findElement(By.id("zipcode"));
    // typeZipcode.sendKeys("12345");

    // WebElement typeMobileNumber = driver.findElement(By.id("mobile_number"));
    // typeMobileNumber.sendKeys("Hà Nội");

    // WebElement submitaccountInfo =
    // driver.findElement(By.xpath("//button[text()='Create Account']"));
    // submitaccountInfo.click();

    // WebElement verifyNote = driver.findElement(By.xpath("//b[text()='Account
    // Created!']"));

    // Assert.assertEquals(verifyNote.getText().toUpperCase(), "ACCOUNT CREATED!");
    // }

    // @AfterMethod
    // public void endRegister() throws InterruptedException {
    // Thread.sleep(5000);
    // driver.quit();
    // }
}
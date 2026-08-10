package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected static String Base_Url = "https://automationexercise.com/";

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(Base_Url);
    }

    @AfterMethod
    public void endRegister() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}

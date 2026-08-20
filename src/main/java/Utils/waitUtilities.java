package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtilities {
    public static boolean verifyUrl(WebDriver driver, String currentUrl) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.urlContains(currentUrl));
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitClickElement(WebDriver driver, By elementClick) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(elementClick)).click();
    }

    public static void waitClickElementforList(WebDriver driver, WebElement elementClick) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(elementClick)).click();
    }

    public static void scrollWindow(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({top: arguments[1], left: arguments[0], behavior:'smooth'});", y, x);
    }

    public static void ScrolltoView(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//footer[contains(@id, 'footer')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'end'});",
                element);
    }
}

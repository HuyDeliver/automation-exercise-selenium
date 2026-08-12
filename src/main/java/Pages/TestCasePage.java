package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage {
    private WebDriver driver;

    public TestCasePage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleTestPage = By.xpath("//h2[text()='Test Cases']");
}

package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.waitUtilities;

public class CategoryPage {
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleCategory = By.cssSelector(".features_items>h2");

    private By manCategory = By
            .xpath("//div[@class='panel-heading']//a[contains(normalize-space(.), 'Men')and @href='#Men']");

    private By panelBody = By.cssSelector(".panel.panel-default");

    private By panelCategory = By.cssSelector("#Men .panel-body>ul>li>a");

    public boolean verifyUrlCategory(String url) {
        return waitUtilities.verifyUrl(driver, url);
    }

    public boolean verifyTitleCategory() {
        return !driver.findElements(titleCategory).isEmpty();
    }

    public void manCategoryClick() {
        waitUtilities.waitClickElement(driver, manCategory);
    }

    public CategoryPage goTomancategoryProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(panelBody));
        waitUtilities.waitClickElement(driver, panelCategory);
        return new CategoryPage(driver);
    }
}

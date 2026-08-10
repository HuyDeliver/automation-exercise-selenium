package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Utils.UserData;

public class EnterAccountInfoPage {
    private final WebDriver driver;

    private final By titleEnterAccountInfo = By.xpath("//b[text()='Enter Account Information']");

    private final By maleTitle = By.id("id_gender1");
    private final By femaleTitle = By.id("id_gender2");
    private final By password = By.id("password");

    private final By day = By.id("days");
    private final By month = By.id("months");
    private final By year = By.id("years");

    private final By newsletter = By.id("newsletter");
    private final By optin = By.id("optin");

    public EnterAccountInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEnterAccountInfoVisible() {
        return !driver.findElements(titleEnterAccountInfo).isEmpty();
    }

    public void fillAccountInfo(UserData user) {
        if ("Mrs".equalsIgnoreCase(user.getTitle())) {
            driver.findElement(femaleTitle).click();
        } else {
            driver.findElement(maleTitle).click();
        }

        driver.findElement(password).sendKeys(user.getPassword());

        new Select(driver.findElement(day)).selectByVisibleText(user.getDay());
        new Select(driver.findElement(month)).selectByVisibleText(user.getMonth());
        new Select(driver.findElement(year)).selectByVisibleText(user.getYear());

        if (user.isNewsletter() && !driver.findElement(newsletter).isSelected()) {
            driver.findElement(newsletter).click();
        }

        if (user.isOptin() && !driver.findElement(optin).isSelected()) {
            driver.findElement(optin).click();
        }
    }
}